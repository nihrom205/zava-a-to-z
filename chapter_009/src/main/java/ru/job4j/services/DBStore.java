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
    private static final DBStore DB_STORE = new DBStore();
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DBStore() {
    }

    public static DBStore getInstance() {
        return DB_STORE;
    }

    /**
     * Метод добавляет 1 заявку в бд.
     * @param item заявка
     */
    @Override
    public void addItem(Item item) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.save(item);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    /**
     * Метод возвращает все заявки из базы.
     * @return Список заявок
     */
    @Override
    public List<Item> getAllItems() {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Item").list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }
}
