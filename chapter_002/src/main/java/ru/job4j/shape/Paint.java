package ru.job4j.shape;

/**
 * Класс для печати фигур.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 22.10.2017
 */
public class Paint {
    /**
     * печать фигур.
     * @param shape фигура
     * @return строка
     */
    public String draw(Shape shape) {
        //System.out.println(shape.pic());
        return shape.pic();
    }
}
