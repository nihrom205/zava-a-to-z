package ru.job4j.loop;

/**
* Class Factorial.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 24.09.2017
*/
public class Factorial {
	/**
	* метод расчитывает факториал.
	* @param n задается число для расчета факторила
	* @return возвращает результат
	*/
	public int calc(int n) {
		int cout = 1;
		for (int i = 1; i <= n; i++) {
			cout *= i;
		}
		return cout;
	}
}