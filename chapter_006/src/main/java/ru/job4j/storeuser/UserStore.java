package ru.job4j.storeuser;

import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class UserStore.
 *
 * клас для хранения Users с учетом многопоточности.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.02.2018
 */
@ThreadSafe
public class UserStore {
    @GuardedBy("this")
    private Map<Integer, User> store = new HashMap();

    /**
     * Добавление элемента в колекцию.
     * @param user Элемент колекции
     * @return true - успешно выполнено, false иначе
     */
    public synchronized boolean add(User user) {
        boolean rezult = false;
        if (!store.containsKey(user.getId())) {
            store.computeIfAbsent(user.getId(), k -> new User(k, user.getAmount()));
            rezult = true;
        }
        return rezult;
    }

    /**
     * Обновление элемента в колеции.
     * @param user Элемент колекции
     * @return true - успешно выполнено, false иначе
     */
    public synchronized boolean update(User user) {
        boolean rezult = false;
        if (store.containsKey(user.getId())) {
            store.computeIfPresent(user.getId(), (k, v) -> new User(k, user.getAmount()));
            rezult = true;
        }
        return rezult;
    }

    /**
     * Удаление элемента из колекции.
     * @param user Элемент колекции
     * @return true - успешно выполнено, false иначе
     */
    public synchronized boolean delete(User user) {
        boolean rezult = false;
        if (store.containsKey(user.getId())) {
            store.remove(user.getId());
            rezult = true;
        }
        return rezult;
    }

    /**
     * Перевод денежных средсв "amount" из элемента "fromId" в элемент "toId"
     * @param fromId источник переолда
     * @param toId получатель перевода
     * @param amount сумма перевода
     * @return true - успешно выполнено, false иначе
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean rezult = false;
        User fromUser = store.get(fromId);
        User toUser = store.get(toId);
        if (fromUser != null && toUser != null) {
            if (fromUser.getAmount() >= amount) {
                fromUser.setAmount(fromUser.getAmount() - amount);
                toUser.setAmount(toUser.getAmount() + amount);
                rezult = true;
            }
        }
        return rezult;
    }
}
