package ru.job4j.shess;

import java.util.Arrays;

/**
 * Класс Ладья.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.11.2017
 */
public class Rook extends Figure {
    public Rook(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] points = new Cell[7];
        int positArray = 0;
        int x1 = this.position.getX();
        int y1 = this.position.getY();

        int x2 = dist.getX();
        int y2 = dist.getY();

        int xRast = x2 - x1;
        int yRast = y2 - y1;

        if (!(x2 >= 0 & x2 <= 7 & y2 >= 0 & y2 <= 7)) {
            throw new ImposibleMoveException();
        } else if (xRast == 0 && yRast == 0) {
            throw new ImposibleMoveException();
        } else if (x1 == x2) {
            if (y1 > y2) {
                // ладья движеться в низ
                for (int i = y1 - 1; i >= y2; i--) {
                    points[positArray++] = new Cell(x1, i);
                }
            } else {
                // ладья движеться в верх
                for (int i = y1 + 1; i <= y2; i++) {
                    points[positArray++] = new Cell(x1, i);
                }
            }
        } else if (y1 == y2) {
            if (x1 > x2) {
                //движение в лево
                for (int i = x1 - 1; i >= x2; i--) {
                    points[positArray++] = new Cell(i, y1);
                }
            } else {
                //движение в право
                for (int i = x1 + 1; i <= x2; i++) {
                    points[positArray++] = new Cell(i, y1);
                }
            }
        }

        return Arrays.copyOf(points, positArray);
    }
}
