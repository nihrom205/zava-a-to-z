package ru.job4j.shess;

import java.util.Arrays;

/**
 * Class Queen.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.11.2017
 */
public class Queen extends Figure {
    public Queen(Cell position) {
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

        int granicaCikla = 0;

        if (!(x2 >= 0 & x2 <= 7 & y2 >= 0 & y2 <= 7)) {
            throw new ImposibleMoveException();
        } else if (x2 - x1 == 0 && y2 - y1 == 0) {
            throw new ImposibleMoveException();
        } else if (x1 == x2) {
            if (y1 > y2) {
                // ладья движеться в низ
                for (int i = y1 - 1; i >= y2; i--) {
                    points[positionArray++] = new Cell(x1, i);
                }
            } else {
                // ладья движеться в верх
                for (int i = y1 + 1; i <= y2; i++) {
                    points[positionArray++] = new Cell(x1, i);
                }
            }
        } else if (y1 == y2) {
            if (x1 > x2) {
                //движение в лево
                for (int i = x1 - 1; i >= x2; i--) {
                    points[positionArray++] = new Cell(i, y1);
                }
            } else {
                //движение в право
                for (int i = x1 + 1; i <= x2; i++) {
                    points[positionArray++] = new Cell(i, y1);
                }
            }
        } else if (x2 > x1 & y2 > y1) {     // 1-ая четверть коорд оси
            granicaCikla = x1 > y1 ? 7 - x1 : 7 - y1;
            for (int i = 0; i < granicaCikla; i++) {
                x1++;
                y1++;
                if (x1 < x2 & y1 < y2) {
                    points[positionArray++] = new Cell(x1, y1);
                } else if (x1 == x2 & y1 == y2) {
                    points[positionArray++] = new Cell(x1, y1);
                    break;
                } else {
                    throw new ImposibleMoveException();
                }
            }
        } else if (x2 < x1 & y2 > y1) {     // 2-ая четверть коорд оси
            granicaCikla = x1 > y1 ? x1 : y1;
            for (int i = 0; i < granicaCikla; i++) {
                x1--;
                y1++;
                if (x1 > x2 & y1 < y2) {
                    points[positionArray++] = new Cell(x1, y1);
                } else if (x1 == x2 & y1 == y2) {
                    points[positionArray++] = new Cell(x1, y1);
                    break;
                } else {
                    throw new ImposibleMoveException();
                }
            }
        } else if (x2 < x1 & y2 < y1) {      // 3-ая четверть коорд оси
            granicaCikla = x1 < y1 ? x1 : y1;
            for (int i = 0; i < granicaCikla; i++) {
                x1--;
                y1--;
                if (x1 > x2 & y1 > y2) {
                    points[positionArray++] = new Cell(x1, y1);
                } else if (x1 == x2 & y1 == y2) {
                    points[positionArray++] = new Cell(x1, y1);
                    break;
                } else {
                    throw new ImposibleMoveException();
                }
            }
        } else if (x2 > x1 & y2 < y1) {
            granicaCikla = x1 < y1 ? x1 : y1;
            for (int i = 0; i < granicaCikla; i++) {
                x1++;
                y1--;
                if (x1 < x2 & y1 > y2) {
                    points[positionArray++] = new Cell(x1, y1);
                } else if (x1 == x2 & y1 == y2) {
                    points[positionArray++] = new Cell(x1, y1);
                    break;
                } else {
                    throw new ImposibleMoveException();
                }
            }
        }

        return Arrays.copyOf(points, positionArray);
    }
}
