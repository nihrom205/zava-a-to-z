package ru.job4j.findlabyrinth;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * класс тестирования
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.03.2018
 */
public class MinimalPathTest {
    @Test
    public void whenMapRouteThenFindRouteStartToFinish() {
        char[][] map = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                     {'.', '#', '#', '.', '#', '.'},
                                     {'.', '.', '.', '#', '#', '.'},
                                     {'#', '#', '.', '#', '.', '.'},
                                     {'#', '.', '.', '#', '.', '#'},
                                     {'.', '@', '#', '.', '.', 'x'}};


        char[][] rezultMap = new char[][] {{'+', '+', '+', '+', '+', '+'},
                                           {'+', '#', '#', '.', '#', '+'},
                                           {'+', '+', '+', '#', '#', '+'},
                                           {'#', '#', '+', '#', '+', '+'},
                                           {'#', '+', '+', '#', '+', '#'},
                                           {'.', '@', '#', '.', '+', 'x'}};
        MinimalPath path = new MinimalPath();
        path.run(map);
        System.out.println();
        assertThat(map, is(rezultMap));
    }

    // тест проверяет коректность, от старта до финиша нет пути (тупик)
    @Test
    public void whenMapDeadlockRouteThenFindRouteStartToFinish() {
        char[][] map = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                     {'.', '#', '#', '.', '#', '.'},
                                     {'.', '#', '.', '#', '#', '.'},
                                     {'#', '#', '.', '#', '.', '.'},
                                     {'#', '.', '.', '#', '.', '#'},
                                     {'.', '@', '#', '.', '.', 'x'}};


        char[][] rezultMap = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                           {'.', '#', '#', '.', '#', '.'},
                                           {'.', '#', '.', '#', '#', '.'},
                                           {'#', '#', '.', '#', '.', '.'},
                                           {'#', '.', '.', '#', '.', '#'},
                                           {'.', '@', '#', '.', '.', 'x'}};
        MinimalPath path = new MinimalPath();
        path.run(map);
        System.out.println();
        assertThat(map, is(rezultMap));
    }

    @Test
    public void whenMap2RouteThenFindRouteStartToFinish() {
        char[][] map = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                     {'.', '#', '#', '#', '.', '.'},
                                     {'.', '.', '.', '#', '.', 'x'},
                                     {'.', '.', '@', '#', '.', '.'},
                                     {'.', '#', '#', '#', '.', '.'},
                                     {'.', '.', '.', '.', '.', '.'}};


        char[][] rezultMap = new char[][] {{'+', '+', '+', '+', '+', '+'},
                                           {'+', '#', '#', '#', '.', '+'},
                                           {'+', '+', '+', '#', '.', 'x'},
                                           {'.', '.', '@', '#', '.', '.'},
                                           {'.', '#', '#', '#', '.', '.'},
                                           {'.', '.', '.', '.', '.', '.'}};
        MinimalPath path = new MinimalPath();
        path.run(map);
        System.out.println();
        assertThat(map, is(rezultMap));
    }

    @Test
    public void whenMap3RouteThenFindRouteStartToFinish() {
        char[][] map = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                     {'.', '.', '.', '#', '.', '.'},
                                     {'.', '.', '.', '#', '.', '.'},
                                     {'.', 'x', '@', '#', '.', '.'},
                                     {'.', '#', '#', '#', '.', '.'},
                                     {'.', '.', '.', '.', '.', '.'}};


        char[][] rezultMap = new char[][] {{'.', '.', '.', '.', '.', '.'},
                                           {'.', '.', '.', '#', '.', '.'},
                                           {'.', '.', '.', '#', '.', '.'},
                                           {'.', 'x', '@', '#', '.', '.'},
                                           {'.', '#', '#', '#', '.', '.'},
                                           {'.', '.', '.', '.', '.', '.'}};
        MinimalPath path = new MinimalPath();
        path.run(map);
        System.out.println();
        assertThat(map, is(rezultMap));
    }
}