package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class BubbleSortTest.
*/
public class BubbleSortTest {
	/**
	* Тестирование класса BubbleSort.
	*/
	@Test
	public void whereArraryThenSortedArray() {
		BubbleSort bubble = new BubbleSort();
		int[] result = bubble.sort(new int[]{5, 1, 2, 7, 3});
		int[] expresion = new int[] {1, 2, 3, 5, 7};
		assertThat(result, is(expresion));
	}

	/**
	* Тестирование класса BubbleSort.
	*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort bubble = new BubbleSort();
		int[] result = bubble.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
		int[] expresion = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expresion));
	}
}
