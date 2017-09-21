package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Calculator.
*/
public class CalculatorTest {
	/**
	* метод для тестирования сложения.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}

	/**
	* метод тестирует вычитание.
	*/
	@Test
	public void whenSubtractOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.subtract(20, 11);
		double result = calc.getResult();
		double expected = 9;
		assertThat(result, is(expected));
	}

	/**
	* метод тестирует умножение.
	*/
	@Test
	public void whenMultipleOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.multiple(5, 6);
		double result = calc.getResult();
		double expected = 30;
		assertThat(result, is(expected));
	}

	/**
	* метод тестирует деление.
	*/
	@Test
	public void whenDivOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(40, 5);
		double result = calc.getResult();
		double expected = 8;
		assertThat(result, is(expected));
	}
}