package ru.job4j.findlabyrinth;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс ищет кротчайший путь от старта до финиша, обходя препядствия.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.03.2018
 */
public class MinimalPath {
    private ArrayList<Node> hindicap = new ArrayList<>();   // помехи, стены ...
    private Deque<Node> path = new LinkedList<>();  // список путей
    private List<Node> listVisit = new LinkedList<>();  // список посещений
    private Node start;
    private Node finish;
    private int height;
    private int width;
    private char[][] map;

    /**
     * Метод запуска программы
     * @param map карта
     */
    public void run(char[][] map) {
        height = map.length;
        width = map[0].length;
        this.map = map;
        init(map);
        path.add(start);
        find();
        printMap();
    }

    /**
     * метод заполняет переменные из переданной карты
     * @param map карта
     */
    private void init(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '#') {
                    hindicap.add(new Node(new Position(j, i)));
                } else if (map[i][j] == '@') {
                    start = new Node(new Position(j, i));
                } else if (map[i][j] == 'x') {
                    finish = new Node(new Position(j, i));
                }
            }
        }
    }

    /**
     * метод поиска кротчайшего пути
     */
    private void find() {
        Node current = start;
        Node parent;
        Node temp = null;
        while (!path.contains(finish)) {    // проверка в списке path есть узел финишь
            if (current != null) {
                temp = enviroment(current);
            } else {
                System.out.println("Пути не существует!");
                break;
            }

            if (temp == null) {
                current = current.getLast();
                path.pollLast();
            } else {
                listVisit.add(temp);
                if (!path.contains(temp)) {
                    path.add(temp);
                    current = temp;
                } else {
                    current = temp.getLast().getNodeFirst();
                }
            }
        }
    }

    /**
     * метод вычисляет растояние от узловых точек
     * @param start начальный узел
     * @param end конечный узел
     * @return расстояние между узлами
     */
    public int lenght(Position start, Position end) {
        return (Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY()));
    }

    /**
     * метод проверят ячейки вокруг переданного узла и возвращает узел с минимальной ценой.
     * @param node узел
     * @return узел с минимальной ценой
     */
    private Node enviroment(Node node) {
        Node current = node;

        Position position = node.getPosition();
        Position pRight = new Position(position.getX() + 1, position.getY());
        Node nodeRight = new Node(pRight, lenght(pRight, current.getPosition()), lenght(pRight, finish.getPosition()), current);

        Position pLeft = new Position(position.getX() - 1, position.getY());
        Node nodeLeft = new Node(pLeft, lenght(pLeft, current.getPosition()), lenght(pLeft, finish.getPosition()), current);

        Position pTop = new Position(position.getX(), position.getY() - 1);
        Node nodeTop = new Node(pTop, lenght(pTop, current.getPosition()), lenght(pTop, finish.getPosition()), current);

        Position pBotton = new Position(position.getX(), position.getY() + 1);
        Node nodeBotton = new Node(pBotton, lenght(pBotton, current.getPosition()), lenght(pBotton, finish.getPosition()), current);

        if (isBorder(nodeRight) & !hindicap.contains(nodeRight) & !path.contains(nodeRight) & !listVisit.contains(nodeRight)) {
            node.add(nodeRight);
        }
        if (isBorder(nodeLeft) & !hindicap.contains(nodeLeft) & !path.contains(nodeLeft) & !listVisit.contains(nodeLeft)) {
            node.add(nodeLeft);
        }
        if (isBorder(nodeTop) & !hindicap.contains(nodeTop) & !path.contains(nodeTop) & !listVisit.contains(nodeTop) & !node.isEmptyArr(nodeTop)) {
            node.add(nodeTop);
        }
        if (isBorder(nodeBotton) & !hindicap.contains(nodeBotton) & !path.contains(nodeBotton) & !listVisit.contains(nodeBotton)) {
            node.add(nodeBotton);
        }
        // сортировка узлов по цене
        node.arraySort();

        return node.getNodeFirst();
    }

    /**
     * Метод проверяет узел на выход за пределы поля, true - узел  в поле, иначе false
     * @param node узел
     * @return true - узел  в поле, иначе false
     */
    private boolean isBorder(Node node) {
        boolean rezult = false;
        Position position = node.getPosition();
        if (position.getX() < width & position.getX() >= 0 & position.getY() < height & position.getY() >= 0) {
            rezult = true;
        }
        return rezult;
    }

    /**
     * выодит в консоль карту с проложенным путем
     */
    private void printMap() {
        path.remove(start);
        path.remove(finish);
        int x;
        int y;
        for (Node node : path) {
            x = node.getPosition().getX();
            y = node.getPosition().getY();
            map[y][x] = '+';
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
