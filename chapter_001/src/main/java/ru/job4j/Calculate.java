package ru.job4j;

/**
* Class Calculate выводит строку "Hello World"
* 
* @author Alexey Rastorguev (mailto:rastorguev00@gmail.com)
* @version $ld$
* @since 15.09.2017
*/
public class Calculate {
	/**
	* Вывод строки в консоль
	* @param args - args.
	*/
	public static void main(String[] args) {
		System.out.println("Hello world.");
	}

	/**
	* Method echo.
	* @param name Alexey Rastorguev (mailto:rastorguev00@gmail.com)
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}