package ru.job4j.parserSql;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class парсит вакансии с сайта и сохраняет в БД..
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.07.2018
 */
public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class);
    private Connection connect = null;
    private int cronTime = 0;
    private List<Job> listJob;
    private Calendar lastRecordDate;
    private boolean isExit = true;

    public static void main(String[] args) {
        if (args.length > 0) {
//            Parser parser = new Parser("chapter_007/app.properties");
            new Parser(args[0]).parse("http://www.sql.ru/forum/job-offers");
        }
    }

    public Parser(String config) {
        Properties pr = new Properties();
        try (FileInputStream fis = new FileInputStream(config)) {
            pr.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String driver = pr.getProperty("jdbc.driver");
        String url = pr.getProperty("jdbc.url");
        String username = pr.getProperty("jdbc.username");
        String password = pr.getProperty("jdbc.password");
        cronTime = Integer.valueOf(pr.getProperty("cron.time"));

        try {
            connect = DriverManager.getConnection(driver + url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(Statement st = connect.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS job_bd (id serial primary key, subject character(200), url character(200), dateJob TIMESTAMP(14))");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connected BD");
        listJob = getFullJobsBD();
        if (listJob.size() > 0) {
            lastRecordDate = listJob.get(0).getCalendar();
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);

            lastRecordDate = calendar;
        }
    }

    /**
     * Метод парсит ваканси с сайта.
     * @param address адрес сайта
     */
    public void parse(String address) {
        StringBuilder sbLink = new StringBuilder();
//        String[] job = new String[3];
        List<String> blockList = new ArrayList<>();
        blockList.add("JavaScript");
        blockList.add("Java Script");
        Calendar curentYear = Calendar.getInstance();
        int pageInt = 2;

        try {
            Document doc = Jsoup.connect(address).get();

            Elements pages = doc.select("table.sort_options").get(1).select("a[href]");
            Collections.reverse(pages);
            pageInt = Integer.valueOf(pages.get(0).text());     // номер последней страницы

            for (int i = 2; i <= pageInt && isExit; i++) {
                sbLink.append(address).append("/").append(i);
                Elements elements = doc.select("table.forumTable").select("tr");
                for (Element element : elements) {
                    String subject = (element.child(1).select("a").size() > 1) ? element.child(1).select("a").first().text() : "";
                    if (subject.contains("Java") & !subject.contains("[закрыт]")) {
                        boolean isBlock = false;
                        for (String elem : blockList) {
                            if (subject.contains(elem)) {
                                isBlock = true;
                                break;
                            }
                        }
                        if (!isBlock) {
                            String url = element.child(1).getElementsByTag("a").first().absUrl("href");
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(getDate(element.child(5).text()));
                            calendar.set(Calendar.SECOND, 00);
                            // сравнивается текущая дата в вакансии с последней датой вакансии в бд
                            if (calendar.before(lastRecordDate)) {
                                isExit = false;
                                break;
                            }
                            Job newJob = new Job(subject, url, calendar);

                            if (!listJob.contains(newJob)) {
                                logger.info(newJob.toString() + "\n");
                                addBase(newJob);
                                listJob.add(newJob);
                            }
                        }
                        isBlock = false;
                    }
                }
                doc = Jsoup.connect(sbLink.toString()).get();
                sbLink.delete(0, sbLink.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод преобразует дату в милесекунды типа long.
     * @param strDate дата
     * @return дата в милесекундах
     */
    private long getDate(String strDate) {
        Calendar cal = Calendar.getInstance();
        String[] timeString;

        if (strDate.contains("сегодня")) {
            String temp = strDate.replaceAll("сегодня, ", "").trim();
            timeString = temp.split(":");
            cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(timeString[0]));
            cal.set(Calendar.MINUTE, Integer.valueOf(timeString[1]));

        } else if (strDate.contains("вчера")) {
            String temp = strDate.replaceAll("вчера, ", "").trim();
            timeString = temp.split(":");
            cal.add(Calendar.DAY_OF_MONTH, -1);
            cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(timeString[0]));
            cal.set(Calendar.MINUTE, Integer.valueOf(timeString[1]));

        } else {
            DateFormat format = new SimpleDateFormat("d MMM yy, H:mm");
            try {
                cal.setTime(format.parse(strDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return cal.getTimeInMillis();
    }

    /**
     * Метод добавляет в БД данные вакансии.
     * @param job
     */
    private void addBase(Job job) {
        StringBuilder sbDate = new StringBuilder();
        try(PreparedStatement st = connect.prepareStatement("INSERT INTO job_bd(subject, url, dateJob) values(?, ?, ?)")) {
            st.setString(1, job.getSubject());
            st.setString(2, job.getUrl());
            Calendar calendar = job.getCalendar();
            sbDate.append(calendar.get(Calendar.YEAR)).append("-").append(calendar.get(Calendar.MONTH)+1).append("-").append(calendar.get(Calendar.DAY_OF_MONTH)).append(" ");
            sbDate.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
            st.setTimestamp(3, Timestamp.valueOf(sbDate.toString()));
            sbDate.delete(0, sbDate.length());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                    connect.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Метод из БД сохраняет в список
     * @return список
     */
    private List<Job> getFullJobsBD() {
        List<Job> list = new LinkedList<>();
        String dateFormat = "yyyy-MM-dd H:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        try(Statement st = connect.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM job_bd;");
            while(rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(rs.getString("datejob")));
                list.add(new Job(rs.getString("subject").trim(), rs.getString("url").trim(), calendar));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
