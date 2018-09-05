package ru.job4j.parserSql;

import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.07.2018
 */
public class ParserTest {
    @Test
    public void whenParser() {
        Parser parse = new Parser();
        parse.parse("http://www.sql.ru/forum/job-offers");

//        Calendar calendar = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//
//        calendar.set(Calendar.HOUR_OF_DAY, 14);
//        calendar.set(Calendar.MINUTE, 20);
//        calendar.set(Calendar.SECOND, 00);
//
//        calendar2.set(Calendar.HOUR_OF_DAY, 14);
//        calendar2.set(Calendar.MINUTE, 20);
//        calendar2.set(Calendar.SECOND, 01);
//
//        System.out.println(calendar.getTimeInMillis() + " - " + calendar.getTime().toString());
//        System.out.println(calendar2.getTimeInMillis() + " - " + calendar2.getTime().toString());
//        if (calendar.after(calendar2)) {
//            System.out.println("после");
//        } else {
//            System.out.println("до");
//        }

//        if (calendar.before(calendar2)) {
//            System.out.println("после");
//        } else {
//            System.out.println("до");
//        }
//
//        Job job1 = new Job("aaa", "http://e1.ru", calendar);
//        Job job2 = new Job("bbb", "http://e1.ru", calendar);
//        Job job3 = new Job("aaa", "http://e1.ru", calendar);
//        List<Job> list = new LinkedList<>();
//        list.add(job1);
//        list.add(job2);
//
//        if (list.contains(job3)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    }

}
