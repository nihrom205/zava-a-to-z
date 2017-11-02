package ru.job4j.shess;

import java.util.Arrays;

/**
 * Class King.
 * описывает передвижени короля.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.11.2017
 */
public class King extends Figure {
    public King(Cell position) {
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

        if (!(x2 >= 0 & x2 <= 7 & y2 >= 0 & y2 <= 7)) {
            throw new ImposibleMoveException();
        } else if (x2 - x1 == 0 & y2 - y1 == 0) {
            throw new ImposibleMoveException();
        } else if (x1 + 1 == x2 & y1 == y2) {
            points[positionArray++] = new Cell(x1 + 1, y1);
        } else if (x1 + 1 == x2 & y1 + 1 == y2) {
            points[positionArray++] = new Cell(x1 + 1, y1 + 1);
        } else if (x1 == x2 & y1 + 1 == y2) {
            points[positionArray++] = new Cell(x1, y1 + 1);
        } else if (x1 - 1 == x2 & y1 + 1 == y2) {
            points[positionArray++] = new Cell(x1 - 1, y1 + 1);
        } else if (x1 - 1 == x2 & y1 == y2) {
            points[positionArray++] = new Cell(x1 - 1, y1);
        } else if (x1 - 1 == x2 & y1 - 1 == y2) {
            points[positionArray++] = new Cell(x1 - 1, y1 - 1);
        } else if (x1 == x2 & y1 - 1 == y2) {
            points[positionArray++] = new Cell(x1, y1 - 1);
        } else if (x1 + 1 == x2 & y1 - 1 == y2) {
            points[positionArray++] = new Cell(x1 + 1, y1 - 1);
        } else {
            throw new ImposibleMoveException();
        }

        return Arrays.copyOf(points, positionArray);
    }
}
