package ru.job4j.chess;

import java.util.Arrays;

/**
 * Класс Ладья.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 10.11.2017
 */
public class Rook extends King {
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
                positArray = this.figureMoveDown(y1, y2, x1, points, positArray);
            } else {
                // ладья движеться в верх
                positArray = this.figureMoveUp(y1, y2, x1, points, positArray);
            }
        } else if (y1 == y2) {
            if (x1 > x2) {
                //движение в лево
                positArray = this.figureMoveLeft(x1, x2, y1, points, positArray);
            } else {
                //движение в право
                positArray = this.figureMoveRight(x1, x2, y1, points, positArray);
            }
        } else {
            throw new ImposibleMoveException();
        }

        return Arrays.copyOf(points, positArray);
    }
}
