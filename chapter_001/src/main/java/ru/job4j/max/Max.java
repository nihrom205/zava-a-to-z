package ru.job4j.max;

/**
* Максимум из 2-х чисел.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 21.09.2017
*/
public class Max {
	/**
	* Метод возвращает максимальное значение из 2-х чисел.
	* @param first первое число
	* @param second первое число
	* @return возвращает максимальное из 2-х чисел
	*/
	public int max(int first, int second) {
		return (first >= second) ? first : second;
	}
}