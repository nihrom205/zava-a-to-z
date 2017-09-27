package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Class RotateArray.
*/
public class RotateArrayTest {
	/**
	* метод тестирует массив чисел 2 х 2.
	*/
	@Test
	public void whenRotateTwoRolTwoColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] result = rotateArray.rotate(new int[][]{{0, 1}, {2, 3}});
		int[][] expression = new int[][]{{2, 0}, {3, 1}};
		assertThat(result, is(expression));
	}

	/**
	* метод тестирует массив чисел 3 х 3.
	*/
	@Test
	public void whenRotateTreeRolTreeColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] result = rotateArray.rotate(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
		int[][] expression = new int[][]{{6, 3, 0}, {7, 4, 1}, {8, 5, 2}};
		assertThat(result, is(expression));
	}
}