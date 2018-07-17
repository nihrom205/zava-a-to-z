package ru.job4j.storeXml;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class для работы с БД.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.07.2018
 */
public class StoreSQL {

    /**
     * Переменная соединения с БД.
     */
    private Connection conn;

    /**
     * Конструктор.
     * @param f файл с настроками подключения к БД.
     */
    public StoreSQL(String f) {
        Properties pr = new Properties();
        try (FileInputStream fis = new FileInputStream(f)) {
            pr.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = pr.getProperty("db.host");

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Метод генерирует элементы и записывает в БД.
     * @param i количество элементо для генерирования данных.
     */
    public void generate(int i) {
        try(Statement st = conn.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS entry (field INTEGER);");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        try (PreparedStatement st = conn.prepareStatement("INSERT INTO entry(field) VALUES(?)")) {
            for (int j = 1; j <= i; j++) {
                st.setInt(1, j);
                st.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * Метод запрашивает из бд все элементы и сохраняет в List.
     * @return список элементов.
     */
    public List<Entry> getList() {
        List<Entry> list = new ArrayList<>();
        try(Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM entry");
            while(rs.next()) {
                list.add(new Entry(rs.getInt("field")));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
