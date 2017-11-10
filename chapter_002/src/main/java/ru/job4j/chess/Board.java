package ru.job4j.chess;

/**
 * Class Board.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 10.11.2017
 */

public class Board {
    public Figure[] figures = new Figure[64];
    private int position = 0;

    /**
     * Метод move.
     *
     * 1) проверка что в заданной ячейке есть фигура, иначе исключение FigureNotFoundException;
     * 2) проверка если фигура есть. может ли она так двигаться, если нет исключение ImposibleMoveException
     * 3) проверка что путь не занят фигурами, если занят OccupiedWayException
     * 4) если все хорошо, записать в ячейку новое положение.
     * @param source исходные координаты
     * @param dist координаты перемещения
     * @return  true - если все условия выполнины, иначе false
     * @throws ImposibleMoveException невозможно пройти к нужному полю
     * @throws OccupiedWayException Поле занятя
     * @throws FigureNotFoundException Такой фигуры не существует
     */
    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figureFound = null;
        Cell[] cells;
        for (Figure figure : figures) {
            if (figure != null && figure.position.equals(source)) {
                figureFound = figure;
                break;
            }
        }
        if (figureFound == null) {
            throw new FigureNotFoundException();
        }
        cells = figureFound.way(dist);
        for (Cell cell : cells) {
            for (Figure figure : figures) {
                if (figure != null) {
                    if (figure.position.equals(cell)) {
                        throw new OccupiedWayException();
                    }
                }
            }
        }

        return true;
    }

    /**
     * Adding figure to board.
     * Добавление фигур на доску.
     * @param figure фигура
     */
    public void addFigure(Figure figure) {
        figures[position++] = figure;
    }
}
