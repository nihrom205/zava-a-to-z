package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class Point.
*/
public class PointTest {
	/**
	* метод для тестирования класса поинт
	* создается точка с 2-я координатами.
	* Далее проверятся находится ли точка на функции.
	*/
	@Test
	public void whenPointOnLineTheTrue() {
		Point point = new Point(2, 4);
		boolean result = point.is(1, 2);
		assertThat(result, is(true));
	}
}