package ru.job4j.oop;

/**
 * Class Order.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Order {
    /**
     * переменная заказ.
     */
    private String zakaz;

    /**
     * метод предоставляет заказ.
     * @return заказ
     */
    public String getZakaz() {
        return zakaz;
    }

    /**
     * метод устанавливает заказ.
     * @param zakaz заказ
     */
    public void setZakaz(String zakaz) {
        this.zakaz = zakaz;
    }
}
