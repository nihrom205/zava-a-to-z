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
		int arraySize = array.length;
		int sizeMass = (arraySize % 2 == 0) ? (array.length / 2) : ((array.length - 1) / 2);
		int finish = array.length - 1;
		for (int i = 0; i < sizeMass; i++) {
				int temp = array[i];
				array[i] = array[finish];
				array[finish--] = temp;
			}
		return array;
	}
}