package ru.job4j.shess;

/**
 * Class Figure.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.11.2017
 */
public abstract class Figure {
    final Cell position;

    /**
     * конструктор.
     * @param position координаты фигуры
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * абстрактный класс.
     * проверяет может ли пройти фигура до нужной ячейки
     * @param dist координата следования
     * @return массив координат следования
     */
    abstract Cell[] way(Cell dist) throws ImposibleMoveException;
}
