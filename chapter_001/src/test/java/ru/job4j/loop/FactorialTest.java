package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Factorial.
*/
public class FactorialTest {
	/**
	* метод тестирует факториал до 5 включительно.
	*/
	@Test
	public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(5);
		assertThat(result, is(120));
	}

	/**
	* метод тестирует факториал до 1 включительно.
	*/
	@Test
	public void whenCalculateFactorialForOneThenOne() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(1);
		assertThat(result, is(1));
	}
}