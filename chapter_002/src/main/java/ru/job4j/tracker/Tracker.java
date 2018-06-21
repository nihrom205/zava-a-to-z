package ru.job4j.tracker;

import java.io.FileInputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Class Tracker.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 19.06.2018
 */
public class Tracker implements AutoCloseable {

    private Connection conn = null;

    public Tracker(String f) {
        Properties pr = new Properties();
        try (FileInputStream fis = new FileInputStream(f)) {
            pr.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = pr.getProperty("db.host");
        String username = pr.getProperty("db.username");
        String password = pr.getProperty("db.password");

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS items (id serial primary key, name varchar(100), description varchar(2000), create_date timestamp, comments varchar(2000));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для добавление заявки в БД.
     * @param item заяка
     * @return заявка
     */
    public Item add(Item item) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO items(name, description, create_date) values(?, ?, ?)")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setDate(3, new Date(item.getCreated()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Обновление заявки.
     * @param item заявка
     */
    public void update(Item item) {
        try (PreparedStatement st = conn.prepareStatement("UPDATE items SET name = ?, description = ?, create_date = ? WHERE id = ?")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setDate(3, new Date(item.getCreated()));
            st.setInt(4, Integer.valueOf(item.getId()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление заявки.
     * @param item заявка
     */
    public void delete(Item item) {
        try (PreparedStatement st = conn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            st.setInt(1, Integer.valueOf(item.getId()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * возвращает все заявки.
     * @return массив заявок
     */
    public List<Item> findAll() {
        List<Item> listItems = new LinkedList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                listItems.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name"), rs.getString("description"), (rs.getDate("create_date")).getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItems;
    }

    /**
     * ищет заявку по наименованию.
     * @param key наименование заявки
     * @return массив заявок
     */
    public List<Item> findByName(String key) {
        List<Item> listItems = new LinkedList<>();
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listItems.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name"), rs.getString("description"), (rs.getDate("create_date")).getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItems;
    }

    /**
     * ищет заявку по id.
     * @param id id
     * @return заявку
     */
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            st.setInt(1, Integer.valueOf(id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result = new Item(String.valueOf(rs.getInt("id")), rs.getString("name"), rs.getString("description"), (rs.getDate("create_date")).getTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
