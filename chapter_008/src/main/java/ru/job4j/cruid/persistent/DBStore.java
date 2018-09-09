package ru.job4j.cruid.persistent;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import ru.job4j.cruid.dao.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.09.18
 */
public class DBStore implements Store<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore DBSTORE = new DBStore();

    private DBStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/java_atoz_bd");
        SOURCE.setUsername("alex");
        SOURCE.setPassword("alex105");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        return DBSTORE;
    }

    @Override
    public void add(User user) {
        try(Connection con = SOURCE.getConnection(); PreparedStatement pr = con.prepareStatement("insert into users(login, email) values(?, ?)")) {
            pr.setString(1, user.getName());
            pr.setString(2, user.getEmail());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try(Connection con = SOURCE.getConnection(); PreparedStatement pr = con.prepareStatement("UPDATE users SET login=?, email=? WHERE id=?")) {
            pr.setString(1, user.getName());
            pr.setString(2, user.getEmail());
            pr.setInt(3, user.getId());
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection con = SOURCE.getConnection(); PreparedStatement pr = con.prepareStatement("DELETE FROM users WHERE id= ?")) {
            pr.setInt(1, id);
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new LinkedList<>();
        try(Connection con = SOURCE.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM users")) {
            while(rs.next()) {
                list.add(new User(Integer.valueOf(rs.getString("id")), rs.getString("login"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(int id) {
        User result = null;
        try(Connection con = SOURCE.getConnection(); PreparedStatement pr = con.prepareStatement("SELECT * FROM users where id = ?")) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                result = new User(Integer.valueOf(rs.getString("id")), rs.getString("login"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
