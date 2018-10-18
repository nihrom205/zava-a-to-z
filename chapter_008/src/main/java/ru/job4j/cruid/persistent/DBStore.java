package ru.job4j.cruid.persistent;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.job4j.cruid.dao.Role;
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
    public User add(User user) {
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("insert into users(login, email) values(?, ?)")) {
            pr.setString(1, user.getName());
            pr.setString(2, user.getEmail());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("UPDATE users SET login=?, email=?, password=?, role=? WHERE id=?")) {
            pr.setString(1, user.getName());
            pr.setString(2, user.getEmail());
            pr.setString(3, user.getPassword());
            pr.setInt(4, Integer.valueOf(user.getRole()));
            pr.setInt(5, user.getId());
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("DELETE FROM users WHERE id= ?")) {
            pr.setInt(1, user.getId());
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new LinkedList<>();
        try(Connection con = SOURCE.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select users.id, users.login, users.email, users.password, r.role from users  left join roles r on users.role = r.id")) {
            while(rs.next()) {
                list.add(new User(Integer.valueOf(rs.getString("id")), rs.getString("login"), rs.getString("email"), rs.getString("password"), rs.getString("role")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(User user) {
        User result = null;
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("select users.id, users.login, users.email, users.password, r.role from users  left join roles r on users.role = r.id where users.id=?")) {
            pr.setInt(1, user.getId());
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                result = new User(Integer.valueOf(rs.getString("id")), rs.getString("login"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User findByLogin(User user) {
        User result = null;
        try(Connection con = SOURCE.getConnection(); PreparedStatement pr = con.prepareStatement("select users.id, users.login, users.email, users.password, r.role from users  left join roles r on users.role = r.id where users.login = ?")) {
            pr.setString(1, user.getName());
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                result = new User(Integer.valueOf(rs.getString("id")), rs.getString("login"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> listRole = new LinkedList<>();
        try(Connection con = SOURCE.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from roles")) {
                while(rs.next()) {
                    listRole.add(new Role(Integer.valueOf(rs.getString("id")), rs.getString("role"), rs.getString("description")));
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listRole;
    }

    @Override
    public void addRole(Role role) {
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("insert into roles(role, description) values(?, ?)")) {
            pr.setString(1, role.getName());
            pr.setString(2, role.getDescription());
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delRole(Role role) {
        try(Connection con = SOURCE.getConnection();
            PreparedStatement pr = con.prepareStatement("delete from roles where id=?")) {
            pr.setInt(1, role.getId());
            pr.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
