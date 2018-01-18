package ru.job4j.frog;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node.
 * класс для хранения узла.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.01.2018
 */
public class Node {
    private int x;    // точк старта лягушки
    private int y;
    private List array = new ArrayList<Node>();   // массив доступных точек прыжка из этого узла

    // конструктор
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // геттер ======================
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // =============================

    // добавить узел массив
    public void addNode(Node node) {
        array.add(node);
    }

    // возвращает список узлов
    public List<Node> allListNode() {
        return array;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (x != node.x) return false;
        return y == node.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
