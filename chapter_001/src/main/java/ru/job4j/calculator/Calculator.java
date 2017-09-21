package ru.job4j.calculator;

/**
* Class Calculator выполняет математические операции.
* сложение, вычитание, деление, умножение.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $ld$
* @since 21.09.2017
*/
public class Calculator {
	/**
	* результат.
	*/
	private double result;

	/**
	* метод сложения 2-х чисел.
	* @param first 1-ое число
	* @param second 2-ое число
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* метод вычитания 2-х чисел.
	* @param first 1-ое число
	* @param second 2-ое число
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	* метод деления 2-х чисел.
	* @param first 1-ое число
	* @param second 2-ое число
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	* метод умножения 2-х чисел.
	* @param first 1-ое число
	* @param second 2-ое число
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	* метод возврашяет результат.
	* @return result
	*/
	public double getResult() {
		return this.result;
	}
}