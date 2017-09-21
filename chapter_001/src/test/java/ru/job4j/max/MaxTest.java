package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* MaxTest.
*/
public class MaxTest {
	/**
	* метод для тестироания максимального числа.
	* первое число больше второго.
	*/
	@Test
	public void whenTwoNumberThenMax() {
		Max maxim = new Max();
		int result = maxim.max(30, 5);
		assertThat(result, is(30));
	}

	/**
	* метод для тестироания максимального числа.
	* первое число меньше второго.
	*/
	@Test
	public void whenSecondLargeFirst() {
		Max maxim = new Max();
		int result = maxim.max(1, 5);
		assertThat(result, is(5));
	}

	/**
	* метод для тестироания максимального числа.
	* числа равны.
	*/
	@Test
	public void whenFirstEqualsSecond() {
		Max maxim = new Max();
		int result = maxim.max(41, 41);
		assertThat(result, is(41));
	}
}