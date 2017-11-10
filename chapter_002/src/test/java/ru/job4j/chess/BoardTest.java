package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Chess.
 */
public class BoardTest {

//    @Test(expected = ImposibleMoveException.class)
    @Test(expected = OccupiedWayException.class)
//    @Test
    public void whereBoardElephanThenBoardMovementElephant() throws FigureNotFoundException, ImposibleMoveException, OccupiedWayException {
        Board board = new Board();
        boolean result = false;
        board.addFigure(new Pawn(new Cell(0, 4)));
        board.addFigure(new Elephant(new Cell(1, 4)));
        board.addFigure(new Horse(new Cell(2, 2)));
        board.addFigure(new Queen(new Cell(4, 4)));
        board.addFigure(new Rook(new Cell(5, 0)));
        board.addFigure(new King(new Cell(5, 6)));

        result = board.move(new Cell(1, 4), new Cell(5, 0));

        assertThat(result, is(true));
    }
}
