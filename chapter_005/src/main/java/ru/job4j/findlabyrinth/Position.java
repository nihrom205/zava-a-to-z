package ru.job4j.findlabyrinth;

/**
 * Class описывает координаты.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.03.2018
 */
public class Position {
    private int x;
    private int y;

    /**
     * конструктор
     * @param x координата х
     * @param y координата y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер
      * @return координату x
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер
     * @return координату y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }
}
