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
        if (map.containsKey(user)) {
            map.get(user).add(account);
        }
    }

    /**
     * удалить один счет пользователя.
     * @param user пользователь
     * @param account аккаунт
     */
    public void deketeAccountFromUser(User user, Account account) {
        if (map.containsKey(user)) {
            Iterator<Account> iter = map.get(user).iterator();
            while (iter.hasNext()) {
                Account acc = iter.next();
                if (acc.getRequisites() == account.getRequisites()) {
                    iter.next();
                    iter.remove();
                    break;
                }
            }
        }

    }

    /**
     * получить список счетов для пользователя.
     * @param user пользователь
     * @return список счетов
     */
    public List<Account> getUserAccounts(User user) {
        return (this.map.containsKey(user))? this.map.get(user) : new ArrayList<Account>();
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
        if (map.containsKey(srcUser) && map.containsKey(dstUser)) {
            Account srcAcc = this.getAccount(map.get(srcUser), srcAccount);
            Account dstAcc = this.getAccount(map.get(dstUser), dstAccount);
            if (srcAcc.getValue() >= amound) {
                srcAcc.setValue(srcAcc.getValue() - amound);
                dstAcc.setValue(dstAcc.getValue() + amound);
                transfer = true;
            }
        }
        return transfer;
    }

    /**
     * метод возвращает ищет Account из списка, если нашел то возвращает, иначе null.
     * @param listAcc список аккаунтов
     * @param account искомый аккаунт
     * @return найденый аккаунт
     */
    private Account getAccount(List<Account> listAcc, Account account) {
        Account acc = null;
        for (Account value : listAcc) {
            if (account.getRequisites() == value.getRequisites()){
                acc = value;
                break;
            }
        }
        return acc;
    }
}
