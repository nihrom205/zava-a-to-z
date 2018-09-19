package ru.job4j.cruid.dao;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.08.18
 */
public class User {
    private int id;
    private String login;
    private String email;
    private Date createDate;

    public User(int id, String name, String email) {
        this.id = id;
        this.login = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
