package ru.job4j.salescars.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.salescars.models.Car;
import ru.job4j.salescars.service.DBStore;

import java.util.LinkedList;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.01.2019
 */
public class DBStoreImpl<T> implements DBStore<T> {
    private final static DBStore DB_STORE = new DBStoreImpl();
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private DBStoreImpl() {
    }

    public static DBStore getInstance() {
        return DB_STORE;
    }

    @Override
    public void add(T t) {
        Session session = sessionFactory.openSession();
        try {
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T t) {
        Session session = sessionFactory.openSession();
        try {
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        Session session = sessionFactory.openSession();
        try {
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    /**
     * Метод возвращает все машины
     * @return списо машин
     */
    public List<Car> getAllCar() {
        Session session = sessionFactory.openSession();
        List<Car> cars = new LinkedList<>();
        try {
            return cars = session.createQuery("from Car").list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return cars;
        }
    }

    public List<Car> getAllCarToUser() {
        Session session = sessionFactory.openSession();
        List<Car> cars = new LinkedList<>();
//        return cars = session.createQuery(from User)
        return cars;
    }


}
