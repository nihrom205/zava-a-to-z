package ru.job4j.condition;

/**
* Класс вычисляет площадь треугольника.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 22.09.2017
*/
public class Triangle {
	/**
	* переменная типа Point для хранения координат точки a.
	*/
	private Point a;
	/**
	* переменная типа Point для хранения координат точки b.
	*/
	private Point b;
	/**
	* переменная типа Point для хранения координат точки c.
	*/
	private Point c;

	/**
	* Конструктор для создания треугольника по заданным точкам.
	* @param a первая координата
	* @param b вторая координата
	* @param c третья координата
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Метод вычисляет растояние между правой точкой и левой.
	* @param left левая точка
	* @param right правая точка
	* @return растояние между точками
	*/
	public double distance(Point left, Point right) {
		int x = right.getX() - left.getX();
		x *= x;
		int y = right.getY() - left.getY();
		y *= y;
		return Math.sqrt(x + y);
	}

	/**
	* Метод вычисления периметра по длинам сторон.
	* @param ab расстояние между точками ab
	* @param ac расстояние между точками ac
	* @param bc расстояние между точками bc
	* @return периметр треугольника
	*/
	public double period(double ab, double ac, double bc) {
		return (ab + ac + bc) / 2;
	}

	/**
	* Метод вычисляет площадь треугольника.
	* @return возвращате площадь треугольника
	*/
	public double areal() {
		double rsl = -1;
		double ab = this.distance(this.a, this.b);
		double ac = this.distance(this.a, this.c);
		double bc = this.distance(this.b, this.c);
		double p = this.period(ab, ac, bc);
		if (this.exist(ab, ac, bc)) {
			rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
		}
		return rsl;
	}

	/**
	* Метод проверяет может ли существовать треугольник.
	* @param ab расстояние между точками ab
	* @param ac расстояние между точками ac
	* @param bc расстояние между точками bc
	* @return возвращает true или false
	*/
	public boolean exist(double ab, double ac, double bc) {
		if (ab <= 0 && ac <= 0 && bc <= 0) {
			return false;
		}
		return (ab + ac > bc && ab + bc > ac && ac + bc > ab) ? true : false;
	}
}