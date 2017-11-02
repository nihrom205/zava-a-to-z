package ru.job4j.shess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Chess.
 */
public class BoardTest {

    @Test
    public void whereBoardElephanThenBoardMovementElephant() {
        Board board = new Board();
        board.figures[0] = new Pawn(new Cell(0, 1));
        board.figures[1] = new Pawn(new Cell(0, 3));
        board.figures[2] = new Pawn(new Cell(1, 1));
        board.figures[3] = new Elephant(new Cell(2, 0));
        board.figures[4] = new Elephant(new Cell(5, 0));
        boolean result = false;
        try {
            result = board.move(new Cell(2, 0), new Cell(0, 2));
            assertThat(result, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
