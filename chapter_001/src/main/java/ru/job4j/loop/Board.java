package ru.job4j.loop;
/**
* Class Board.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 24.09.2017
*/
public class Board {
	/**
	* Метод рисует шахматную доску в псевдографике.
	* @param width ширина доски
	* @param height высота доски
	* @return строка в псевдографике
	*/
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		String line = System.getProperty("line.separator");
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						sb.append('x');
					} else {
						sb.append(' ');
					}
				} else {
					if (j % 2 != 0) {
						sb.append('x');
					} else {
						sb.append(' ');
					}
				}
			}
			sb.append(line);
		}
		return sb.toString();
	}
}
