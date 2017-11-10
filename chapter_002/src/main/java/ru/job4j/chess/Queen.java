package ru.job4j.chess;

import java.util.Arrays;

/**
 * Class Queen.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 10.11.2017
 */
public class Queen extends King {
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
                // ладья движеться вниз
                this.figureMoveDown(y1, y2, x1, points, positionArray);
            } else {
                // ладья движеться вверх
                positionArray = this.figureMoveUp(y1, y2, x1, points, positionArray);
            }
        } else if (y1 == y2) {
            if (x1 > x2) {
                //движение в лево
                this.figureMoveLeft(x1, x2, y1, points, positionArray);
            } else {
                //движение в право
                this.figureMoveRight(x1, x2, y1, points, positionArray);
            }
        } else if (x2 > x1 & y2 > y1) {     // 1-ая четверть коорд оси
            // движение фигуры вправо-вверх
            positionArray = this.figureMoveRightUp(x1, x2, y1, y2, points, positionArray);
        } else if (x2 < x1 & y2 > y1) {     // 2-ая четверть коорд оси
            // движение фигуры влево-вверх
            positionArray = this.figureMoveLeftUp(x1, x2, y1, y2, points, positionArray);
        } else if (x2 < x1 & y2 < y1) {      // 3-ая четверть коорд оси
            // движение фигуры влево-вниз
            positionArray = this.figureMoveLeftDown(x1, x2, y1, y2, points, positionArray);
        } else if (x2 > x1 & y2 < y1) {
            // движение фигуры вправо-вниз
            positionArray = this.figureMoveRightDown(x1, x2, y1, y2, points, positionArray);
        }

        return Arrays.copyOf(points, positionArray);
    }

}
