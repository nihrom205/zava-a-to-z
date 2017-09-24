package ru.job4j.array;

/**
* Class Turn.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 24.09.2017
*/
public class Turn {
	/**
	* метод переворачивает массив задом на перед.
	* @param array массив для обработки
	* @return обработанный массив
	*/
	public int[] back(int[] array) {
		int[] result = new int[array.length];
		int pointer = array.length - 1;
		for (int entry : array) {
			result[pointer--] = entry;
		}
		return result;
	}
}