package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* тестирует клас Triangle.
*/

public class TriangleTest {
	/**
	* метод тестирует растояние между.
	*/
	@Test
	public void whenAreaSetThreePointsThenTriangleArea() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 8);
		Point c = new Point(4, 6);

		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.distance(a, b);
		assertThat(result, closeTo(7, 0.1));
	}
}