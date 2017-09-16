package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
*
* @author Alexey Rastorguev (rastorguev00@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
	/**
	* Test add.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Alexey Rastorguev";
		String except = "Echo, echo, echo : Alexey Rastorguev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(except));
	}
}