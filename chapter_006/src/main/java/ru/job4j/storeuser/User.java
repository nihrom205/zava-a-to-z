package ru.job4j.storeuser;

/**
 * Class User.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.02.2018
 */
public class User {
    private int id;
    private int amount;

    /**
     * конструктор
     * @param id уникальный номер пользователя
     * @param amount сумма денег
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
