package ru.job4j.chess;

import java.util.Arrays;

/**
 * фигура слон.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 10.11.2017
 */
public class Elephant extends King {
    Elephant(Cell position) {
        super(position);
    }

    /**
     * проверка, может ли фигурай пройти до нужной позиции.
     * @param dist координата следования
     * @return массив координат следования
     */
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] points = new Cell[7];
        int positionArray = 0;
        int x1 = this.position.getX();
        int y1 = this.position.getY();

        int x2 = dist.getX();
        int y2 = dist.getY();

        int granicaCikla = 0;

        if (!(x2 >= 0 & x2 <= 7 & y2 >= 0 & y2 <= 7)) {
            throw new ImposibleMoveException();
        } else if (x2 - x1 == 0 & y2 - y1 == 0) {
            throw new ImposibleMoveException();
        } else if (x2 > x1 & y2 > y1) {     // 1-ая четверть коорд оси
            positionArray = this.figureMoveRightUp(x1, x2, y1, y2, points, positionArray);
        } else if (x2 < x1 & y2 > y1) {     // 2-ая четверть коорд оси
            positionArray = this.figureMoveLeftUp(x1, x2, y1, y2, points, positionArray);
        } else if (x2 < x1 & y2 < y1) {      // 3-ая четверть коорд оси
            positionArray = this.figureMoveLeftDown(x1, x2, y1, y2, points, positionArray);
        } else if (x2 > x1 & y2 < y1) {     // 4-ая четверть коорд оси
            positionArray = this.figureMoveRightDown(x1, x2, y1, y2, points, positionArray);
        } else {
            throw new ImposibleMoveException();
        }
        return Arrays.copyOf(points, positionArray);
    }
}
