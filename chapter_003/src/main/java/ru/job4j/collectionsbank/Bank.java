package ru.job4j.collectionsbank;

import java.util.*;

/**
 * Class Bank.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.11.2017
 */
public class Bank {
    private final Map<User, List<Account>> map = new HashMap<>();

    /**
     * добавление пользователя.
     * @param user пользователь
     */
    public void addUser(User user) {
        this.map.put(user, new ArrayList<Account>());
    }

    /**
     * удаление пользователя.
     * @param user пользователь
     */
    public void deleteUser(User user) {
        map.remove(user);
    }

    /**
     * добавить счет пользователю.
     * @param user пользователь
     * @param account аккаунт пользователя
     */
    public void addAccountToUser(User user, Account account) {
        map.computeIfPresent(user, (k, v) -> {
           v.add(account);
           return v;
        });

    }

    /**
     * удалить один счет пользователя.
     * @param user пользователь
     * @param account аккаунт
     */
    public void deleteAccountFromUser(User user, Account account) {
        map.computeIfPresent(user, (k, v) -> {
            v.remove(v.indexOf(account));
            return v;
        });
    }

    /**
     * получить список счетов для пользователя.
     * @param user пользователь
     * @return список счетов
     */
    public List<Account> getUserAccounts(User user) {
        return map.computeIfPresent(user, (k, v) -> v);
    }

    /**
     * метод переводит денежные средства с одного аккаута пользователя на другой.
     * @param srcUser пользователь от которого осуществляем перевлд
     * @param srcAccount аккаунт с которого осуществляем перевлд
     * @param dstUser пользователь которому осуществляем перевлд
     * @param dstAccount аккаунт на который осуществляем перевод
     * @param amound сумма для перевода
     * @return true если перевод удался, иначе false
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amound) {
        boolean transfer = false;
        List<Account> listSrc = map.computeIfPresent(srcUser, (k, v) -> v);
        Account srcAcc = listSrc.get(listSrc.indexOf(srcAccount));

        List<Account> listDst = map.computeIfPresent(dstUser, (k, v) -> v);
        Account dstAcc = listDst.get(listDst.indexOf(dstAccount));

        if (srcAcc.getValue() >= amound) {
            srcAcc.setValue(srcAcc.getValue() - amound);
            dstAcc.setValue(dstAcc.getValue() + amound);
            transfer = true;
        }
        return transfer;
    }
}
