package ru.job4j.salescars.service;

import ru.job4j.salescars.models.Car;

import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 09.01.2019
 */
public interface DBStore<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
    List<Car> getAllCar();
}
