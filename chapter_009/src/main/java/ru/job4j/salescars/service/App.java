package ru.job4j.salescars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.salescars.models.*;
import ru.job4j.salescars.service.impl.DBStoreImpl;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 09.01.2019
 */
public class App {
    public static void main(String[] args) throws JsonProcessingException {

//        Role roleAdmin = new Role();
//        roleAdmin.setNameRole("Administrator");
//        roleAdmin.setDescription("Самый главный Administrator");
//        DBStoreImpl.getInstance().add(roleAdmin);
//
//        Role roleUser = new Role();
//        roleUser.setNameRole("User");
//        roleUser.setDescription("Обычный пользователь");
//        DBStoreImpl.getInstance().add(roleUser);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//        Car car = session.get(Car.class, 2);
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", 1);
        List list = query.list();
        int i =0;
        session.close();
        factory.close();


//        User user1 = new User();
//        user1.setFirstName("Алексей");
//        user1.setLastName("Расторгуев");
//        user1.setRole(roleAdmin);
//        DBStoreImpl.getInstance().add(user1);
//
//        User user2 = new User();
//        user2.setFirstName("Олег");
//        user2.setLastName("Романов");
//        user2.setRole(roleUser);
//        DBStoreImpl.getInstance().add(user2);




    }
}
