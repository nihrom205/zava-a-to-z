package ru.job4j.shess;

import java.util.Arrays;

/**
 * класс конь.
 * описывает  движение коня.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.11.2017
 */
public class Horse extends Figure {

    public Horse(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] points = new Cell[7];
        int positionArray = 0;
        int x1 = this.position.getX();
        int y1 = this.position.getY();

        int x2 = dist.getX();
        int y2 = dist.getY();
        int i = 0;

        if (!(x2 >= 0 & x2 <= 7 & y2 >= 0 & y2 <= 7)) {
            throw new ImposibleMoveException();
        } else if (x2 - x1 == 0 & y2 - y1 == 0) {
            throw new ImposibleMoveException();
        } else if (x2 > x1 & y2 > y1) {
            // 1-ая четверть коорд оси
            if (x1 + 1 == x2 & y1 + 2 == y2) {
                //цикл
                i = y1 + 1;
                for (; i <= y2; i++) {
                    points[positionArray++] = new Cell(x1, i);
                }
                points[positionArray++] = new Cell(x1 + 1, i);
            } else if (x1 + 2 == x2 & y1 + 1 == y2) {
                // цикл
                i = x1 + 1;
                for (; i <= x2; i++) {
                    points[positionArray++] = new Cell(i, y1);
                }
                points[positionArray++] = new Cell(i - 1, y1 + 1);
            } else {
                throw new ImposibleMoveException();
            }
        } else if (x2 < x1 & y2 > y1) {
            // 2-ая четверть коорд оси
            if (x1 - 1 == x2 & y1 + 2 == y2) {
                i = y1 + 1;
                for (; i <= y2; i++) {
                    points[positionArray++] = new Cell(x1, i);
                }
                points[positionArray++] = new Cell(x1 - 1, i - 1);
            } else if (x1 - 2 == x2 & y1 + 1 == y2) {
                i = x1 - 1;
                for (; i >= x2; i--) {
                    points[positionArray++] = new Cell(i, y1);
                }
                points[positionArray++] = new Cell(i + 1, y1 + 1);
            } else {
                throw new ImposibleMoveException();
            }

        } else if (x2 < x1 & y2 < y1) {
            // 3-ая четверть коорд оси
            if (x1 - 2 == x2 & y1 - 1 == y2) {
                i = x1 - 1;
                for (; i >= x2; i--) {
                    points[positionArray++] = new Cell(i, y1);
                }
                points[positionArray++] = new Cell(i + 1, y1 - 1);
            } else if (x1 - 1 == x2 & y1 - 2 == y2) {
                i = y1 - 1;
                for (; i >= y2; i--) {
                    points[positionArray++] = new Cell(x1, i);
                }
                points[positionArray++] = new Cell(x1 - 1, i + 1);
            }
        } else if (x2 > x1 & y2 < y1) {
            // 4-ая четверть коорд оси
            if (x1 + 2 == x2 & y1 - 1 == y2) {
                i = x1 + 1;
                for (; i <= x2; i++) {
                    points[positionArray++] = new Cell(i, y1);
                }
                points[positionArray++] = new Cell(i - 1, y1 - 1);
            } else if (x1 + 1 == x2 & y1 - 2 == y2) {
                i = y1 - 1;
                for (; i >= y2; i--) {
                    points[positionArray++] = new Cell(x1, i);
                }
                points[positionArray++] = new Cell(x1 + 1, i + 1);

            } else {
                throw new ImposibleMoveException();
            }
        } else {
            throw new ImposibleMoveException();
        }
        return Arrays.copyOf(points, positionArray);
    }
}
