package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class BoardTest.
*/
public class BoardTest {
	/**
	* метод тестирует тестирует доску 5 на 4.
	*/
	@Test
	public void whenBoardTreeOnTreeThenString() {
		Board board = new Board();
		String result = board.paint(3, 3);
		final String line = System.getProperty("line.separator");
		String exception = String.format("x x%s x %sx x%s", line, line, line);
		assertThat(result, is(exception));
	}

	/**
	*
	*/
	@Test
	public void whenBoardFiveOnFourThenString() {
		Board board = new Board();
		String result = board.paint(5, 4);
		final String line = System.getProperty("line.separator");
		String exception = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line, line);
		assertThat(result, is(exception));
	}
}