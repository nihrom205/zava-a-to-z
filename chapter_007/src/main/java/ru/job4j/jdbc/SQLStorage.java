package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 13.06.2018
 */
public class SQLStorage {

//    private static final Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/java_test";
        String username = "alex";
        String password = "alex105";
//        String password = "";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);


// Запрос данных из БД.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from users");
            while (rs.next()) {
                System.out.println(String.format("%s - %s", rs.getString("id_user"), rs.getString("name_user")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
//                    log.error(e.getMessage(), e);
                }
            }
        }

    }
}
