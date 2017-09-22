package ru.job4j.condition;

/**
* Class Point, описывает точку в системе координат.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 22.09.2017
*/
public class Point {
	/**
	* переменные для хранения координат точки.
	*/
	private int x;
	/**
	* переменные для хранения координат точки.
	*/
	private int y;

	/**
	* Constructor Point, inicialization variable x and y.
	* @param  x variable x
	* @param  y variable y
	**/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Method return variable x.
	* @return variable x
	*/
	public int getX() {
		return this.x;
	}

	/**
	* Method variable y.
	* @return variable y
	*/
	public int getY() {
		return this.y;
	}

	/**
	* Функция определяет содержиться ли точка в заданных координатах.
	* Возвращает true или false.
	* @param a первая координата
	* @param b вторая координата
	* @return true или false
	*/
	public boolean is(int a, int b) {
		return (getY() == a * getX() + b) ? true : false;
	}
}