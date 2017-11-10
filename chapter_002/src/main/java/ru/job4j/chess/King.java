package ru.job4j.chess;

import java.util.Arrays;

/**
 * Class King.
 * описывает передвижени короля.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 10.11.2017
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
            // фигура движется вправо
            positionArray = this.figureMoveRight(x1, x2, y1, points, positionArray);
        } else if (x1 + 1 == x2 & y1 + 1 == y2) {
            // фигура движется вправо-вверх
            positionArray = this.figureMoveRightUp(x1 , x2, y1, y2, points, positionArray);
        } else if (x1 == x2 & y1 + 1 == y2) {
            // фигура движется вверх
            positionArray = this.figureMoveUp(y1, y2, x1, points, positionArray);
        } else if (x1 - 1 == x2 & y1 + 1 == y2) {
            // фигура движеться влево-вверх
            positionArray = this.figureMoveLeftUp(x1, x2, y1, y2, points, positionArray);
        } else if (x1 - 1 == x2 & y1 == y2) {
            // фигура движеться влево
            positionArray = this.figureMoveLeft(x1, x2, y1, points, positionArray);
        } else if (x1 - 1 == x2 & y1 - 1 == y2) {
            // фигура движеться вниз-влево
            positionArray = this.figureMoveLeftDown(x1, x2,y1, y2, points, positionArray);
        } else if (x1 == x2 & y1 - 1 == y2) {
            // фигура движеться вниз
            positionArray = this.figureMoveDown(y1, y2, x1, points, positionArray);
        } else if (x1 + 1 == x2 & y1 - 1 == y2) {
            // фигура движетсья вниз-вправо
            positionArray = this.figureMoveRightDown(x1, x2, y1, y2, points, positionArray);
        } else {
            throw new ImposibleMoveException();
        }

        return Arrays.copyOf(points, positionArray);
    }

    /**
     * Движение фигура вниз.
     *
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param x1 первая точка оси абцисс
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveDown(int y1, int y2, int x1, Cell[] points, int positionArray) {
        for (int i = y1 - 1; i >= y2; i--) {
            points[positionArray] = new Cell(x1, i);
        }
        return positionArray;
    }

    /**
     * Движение фигуры вверх.
     *
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param x1 первая точка оси абцисс
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveUp(int y1, int y2, int x1, Cell[] points, int positionArray) {
        for (int i = y1 + 1; i <= y2; i++) {
            points[positionArray++] = new Cell(x1, i);
        }
        return positionArray;
    }

    /**
     * Движение фигуры влево.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveLeft(int x1, int x2, int y1, Cell[] points, int positionArray) {
        for (int i = x1 - 1; i >= x2; i--) {
            points[positionArray++] = new Cell(i, y1);
        }
        return positionArray;
    }

    /**
     * Движение фигуры вправо.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveRight(int x1, int x2, int y1, Cell[] points, int positionArray) {
        for (int i = x1 + 1; i <= x2; i++) {
            points[positionArray++] = new Cell(i, y1);
        }
        return positionArray;
    }

    /**
     * Движение фигуры вправо-вверх.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveRightUp(int x1, int x2, int y1, int y2, Cell[] points, int positionArray) throws ImposibleMoveException {
        int granicaCikla = x1 > y1 ? 7 - x1 : 7 - y1;
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
        return positionArray;
    }

    /**
     * Движение фигуры влево-вверх.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveLeftUp(int x1, int x2, int y1, int y2, Cell[] points, int positionArray) throws ImposibleMoveException {
        int granicaCikla = x1 > y1 ? x1 : y1;
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
        return positionArray;
    }

    /**
     * Движение фигуры влево-вниз.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveLeftDown(int x1, int x2, int y1, int y2, Cell[] points, int positionArray) throws ImposibleMoveException {
        int granicaCikla = x1 < y1 ? x1 : y1;
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
        return positionArray;
    }

    /**
     * Движение фигуры вправо-вниз.
     * @param x1 первая точка оси абцисс
     * @param x2 вторая точка оси абцисс
     * @param y1 первая точка оси ординат
     * @param y2 вторая точка оси ординат
     * @param points массив ходов фигуры
     * @param positionArray позиция элеменда в массиве
     */
    public int figureMoveRightDown(int x1, int x2, int y1, int y2, Cell[] points, int positionArray) throws ImposibleMoveException {
        int granicaCikla = x1 > y1 ? x1 : y1;
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
        return positionArray;
    }
}
