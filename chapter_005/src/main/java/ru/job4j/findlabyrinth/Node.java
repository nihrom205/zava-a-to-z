package ru.job4j.findlabyrinth;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс элемента.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.03.2018
 */
public class Node {
    private Position position;
    private Node last;
    private int generalPrice;   // Общая стоимость
    private LinkedList<Node> array = new LinkedList<>();
    private List<Node> lisVisit = new LinkedList<>();   //посещенный узел


    /**
     * конструктор
     * @param position обьект координат
     */
    public Node(Position position) {
        this.position = position;
    }

    /**
     * конструктор
     * @param position обьект координат
     * @param start начало узла
     * @param finish конец узла
     * @param last родител
     */
    public Node(Position position, int start, int finish, Node last) {
        this.position = position;
        this.last = last;
        generalPrice = start * 10 + finish * 10;    // расчет ценности узла
    }

    /**
     * метод возвращает обьек координат
     * @return координаты
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Метод возвращает  общую стоимость
     * @return общая стоимость
     */
//    public int getGeneralPrice() {
//        return generalPrice;
//    }

    /**
     * Метод добавляет узлы вокруг текущего узла в массив.
     * @param node узел для добавления
     */
    public void add(Node node) {
        array.add(node);
    }

    /**
     * метод удаляет элемент из очереди
     */
//    public void del() {
//        array.remove(0);
//    }

    /**
     * метод проверяет пустая ли очередь
     * @return true - пустая, иначе false
     */
//    public boolean isEmtyArray() {
//        return array.isEmpty();
//    }

    /**
     * метод возвращает родительский узел.
     * @return родительский узел
     */
    public Node getLast() {
        return last;
    }

    public void arraySort() {
        array.sort((Node o1, Node o2) -> (o1.generalPrice - o2.generalPrice));
    }

    public Node getNodeFirst() {
        return array.pollFirst();
    }

//    protected void addNodeVisit(Node node) {
//        lisVisit.add(node);
//    }

//    protected List<Node> getListVisit() {
//        return lisVisit;
//    }

    /**
     * проверяет есть ли узел в массиве
     * @param node узел
     * @return true - не найден узел, инече - false
     */
    protected boolean isEmptyArr(Node node) {
        return array.contains(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return position != null ? position.equals(node.position) : node.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" + position + '}';
    }
}
