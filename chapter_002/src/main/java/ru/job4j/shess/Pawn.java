package ru.job4j.shess;

import java.util.Arrays;

/**
 * Класс Пешка.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 01.11.2017
 */
public class Pawn extends Figure {
    public Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] points = new Cell[7];
        int positArray = 0;
        int xSour = this.position.getX();
        int ySour = this.position.getY();

        int xDist = dist.getX();
        int yDist = dist.getY();

        if (xSour == xDist) {
            if (yDist < 8 && yDist - ySour <= 2 && yDist - ySour > 0) {
                for (int i = ySour; i < yDist; i++) {
                    points[positArray++] = new Cell(xSour, i);
                }
            } else {
                throw new ImposibleMoveException();
            }
        } else {
            throw new ImposibleMoveException();
        }
        return Arrays.copyOf(points, positArray);
    }
}
