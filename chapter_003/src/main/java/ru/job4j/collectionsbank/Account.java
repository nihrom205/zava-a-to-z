package ru.job4j.collectionsbank;

import java.util.*;

/**
 * Аккаунт (счета).
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 14.11.2017
 */
public class Account {
    private double value;
    private long requisites;

    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getRequisites() {
        return requisites;
    }

    public void setRequisites(long requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "value=" + "Account{" + value + ", requisites=" + requisites + '}';
    }
}
