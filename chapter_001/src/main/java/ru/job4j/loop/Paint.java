package ru.job4j.loop;

/**
* Class Paint.
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $1d$
* @since 24.09.2017
*/
public class Paint {
	/**
	* метод создает пирамиду в псевдографике.
	* @param h высота пирамиды
	* @return результат в виде строки, псевдографика
	*/
	public String piramid(int h) {
		int width = h + h - 1;
		StringBuilder sb = new StringBuilder();
		String line = System.getProperty("line.separate");
		for (int i = 0; i < h; i++) {
			for (int j = 1; j <= width; j++) {
				if (j >= h - i && j <= h + i) {
					sb.append('^');
				} else {
					sb.append(' ');
				}
			}
			sb.append(line);
		}
		return sb.toString();
	}
}