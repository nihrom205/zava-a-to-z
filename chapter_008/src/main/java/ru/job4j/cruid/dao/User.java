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
    private String name;
    private String login;
    private String email;
    private Date createDate;

    public User(int id,String name) {
        this.id = id;
        this.name = name;
    }


//    public User(int id, String name, String login, String email, Date createDate) {
//
//        this.id = id;
//        this.name = name;
//        this.login = login;
//        this.email = email;
//        this.createDate = createDate;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
