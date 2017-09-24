package ru.job4j.loop;

/**
* Class counter.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 24.09.2017
*/
public class Counter {
	/**
	* метод вычисляет сумму четных чисел в диапозоне от start до finish.
	* Возврашает сумму чисел.
	* @param start начало диапозона чисел
	* @param finish конец диапозона чисел
	* @return сумма четных чисел
	*/
	public int add(int start, int finish) {
		int count = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				count += i;
			}
		}
		return count;
	}
}