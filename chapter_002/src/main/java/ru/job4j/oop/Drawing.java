package ru.job4j.oop;

/**
 * Class Drawing.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Drawing {
    /**
     * переменная чертеж.
     */
    private String draw;

    /**
     * метод предоставляет чертеж.
     * @return чертеж
     */
    public String getDraw() {
        return draw;
    }

    /**
     * метод устанавливает чертеж.
     * @param draw чертеж
     */
    public void setDraw(String draw) {
        this.draw = draw;
    }
}
