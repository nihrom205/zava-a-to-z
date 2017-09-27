package ru.job4j.array;

/**
* Class RotateArray.
* @author AlexeyRastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 27.09.2017
*/
public class RotateArray {
	/**
	* метод повараыивает массив по часовой стрелке.
	* @param array исходный массив
	* @return повернутый массив
	*/
	public int[][] rotate(int[][] array) {
		int m = array[0].length;
		for (int k = 0; k < m / 2; k++) {
			for (int j = k; j < m - 1 - k; j++) {
				int tmp = array[k][j];
				array[k][j] = array[m - 1 - j][k];
				array[m - 1 - j][k] = array[m - 1 - k][m - 1 - j];
				array[m - 1 - k][m - 1 - j] = array[j][m - 1 - k];
				array[j][m - 1 - k] = tmp;
			}
		}
		return array;
	}
}