package ru.job4j.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.Item;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.12.2018
 */
public class DBStore implements DBStoreImpl {
    private static DBStore dbStore = null;
    private Session session = null;
    private SessionFactory factory = null;

    private DBStore() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public static DBStore getInstance() {
        if (dbStore == null) {
            dbStore = new DBStore();
        }
        return dbStore;
    }

    @Override
    public void addItem(Item item) {
        session = factory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> result = null;
        session = factory.openSession();
        session.beginTransaction();
        result = session.createQuery("from Item").list();
        session.close();
        return result;
    }
}
