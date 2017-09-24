package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Тестирование класса Counter.
*/
public class CounterTest {
	/**
	* метод тестирования суммы четных чисел в заданном диапазоне.
	*/
	@Test
	public void whenEventNumberThenSum() {
		Counter counter = new Counter();
		int result = counter.add(1, 10);
		assertThat(result, is(30));
	}
}