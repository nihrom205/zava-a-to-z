package ru.job4j.items.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.items.models.User;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.2018
 */
public class UserStorage {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
//        User user = new User();
//        user.setId(4);
//        user.setLogin("test");
//        user.setPassword("123456");
//        session.save(user);
//        session.saveOrUpdate(user);
//        session.delete(user);
        List<User> list = session.createQuery("from User").list();
        list.forEach(user -> System.out.println(user.getLogin()));
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
