package ru.job4j.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    private SessionFactory factory = null;

    private DBStore() {
        factory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static DBStore getInstance() {
        if (dbStore == null) {
            dbStore = new DBStore();
        }
        return dbStore;
    }

    @Override
    public void addItem(Item item) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.save(item);
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Item> getAllItems() {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Item").list();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }
}
