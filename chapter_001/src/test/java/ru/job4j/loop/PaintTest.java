package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class Paint.
*/
public class PaintTest {
	/**
	* метод тестирует пирамиду высотой 3.
	*/
	@Test
	public void whenPaintTreeHeightThenString() {
		Paint paint = new Paint();
		String result = paint.piramid(3);
		String line = System.getProperty("line.separate");
		String exception = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
		assertThat(result, is(exception));
	}

	/**
	* метод тестирует пирамиду высотой 2.
	*/
	@Test
	public void whenPaintTwoHeightThenString() {
		Paint paint = new Paint();
		String result = paint.piramid(2);
		String line = System.getProperty("line.separate");
		String exception = String.format(" ^ %s^^^%s", line, line);
		assertThat(result, is(exception));
	}
}