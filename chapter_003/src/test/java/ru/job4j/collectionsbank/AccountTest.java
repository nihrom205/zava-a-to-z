package ru.job4j.collectionsbank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.11.2017
 */
public class AccountTest {

    /**
     * тестирование добавления пользователя.
     */
    @Test
    public void whereAddUserThenUserInAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "123");
        User user2 = new User("Dmitriy", "987");
        User user3 = new User("Alex", "456");
        bank.addUser(user1);
        bank.addUser(user2);
//        bank.addUser(user3);
        Account acc1 = new Account(200.15, 1234567890);
        bank.addAccountToUser(user1, acc1);

        Account accDm1 = new Account(20_000.00, 1111111111);
        bank.addAccountToUser(user2, accDm1);

        Account accDm2 = new Account(1_000.00, 22);
        bank.addAccountToUser(user2, accDm2);

//        bank.deleteAccountFromUser(user2, acc3);
//        List<Account> aa = bank.getUserAccounts(user2);

        bank.transferMoney(user1, acc1, user2, accDm1, 100.05);

//        assertThat(bank.map, equalTo(Collections.EMPTY_MAP));

    }

    /**
     * тестирование удаление пользователя.
     */
    @Test
    public void whereDeleteUserThenUserInAccount() {
//        bank.deleteUser(user1);
//        bank.addAccountToUser(user1, new Account(200, 1234567890));
//        bank.addAccountToUser(user2, new Account(20_000, 1111111111));
//        List<Account> list = bank.getUserAccounts(user2);
//        for (Account account : list) {
//            System.out.println(account);
//        }
    }

    /**
     * тест для проверки добавления аккаунта пользователю.
     */
    @Test
    public void whereAddAccountUserThenUserAccount() {

    }

    /**
     * тест для проверки удалени 1-ого счета пользователя.
     */
    @Test
    public void whereDeleteAccountUserThenUserAccount() {

    }

    /**
     * тест для проверки удалени 1-ого счета пользователя.
     */
    @Test
    public void whereTransferUserMoneyAccountThenUserTranferredMoneyAccount() {

    }
}
