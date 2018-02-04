package ru.job4j.frog;

import java.util.*;

/**
 * Class FrogApp.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.01.2018
 */
public class FrogApp {
    private List tree = new ArrayList<Node>();
    private Node start;     // начальная точка
    private Node finish;    // финишная точка
    private Deque path = new ArrayDeque<Node>(); // путь
    private List<Path> listPath = new LinkedList<Path>();

    public FrogApp(int[] args) {

        if (args.length != 0) {

            // точка старта
            this.start = new Node(args[0], args[1]);

            // конечный узел
            this.finish = new Node(args[2], args[3]);

            //  заполнение деревьев
            for (int i = 5; i <= args[4] + 5; i = i + 2) {
                tree.add(new Node(args[i], args[i + 1]));
            }
        }
    }

    // запуск
    public void run() {
        // заполнение дерева возможными путями.
        added(start);

        // вывод на экран
        printList();
    }

    /**
     * метод обходит все сегменты удовлетворяющие условию и сохраняет их, далле ищеться кротчайщий(-ие) пути.
     * @param startNode точка старта
     */
    public void added(Node startNode) {
        Node current = startNode;
        this.path.addLast(current);
        Node temp = null;

        // проверка  1 шаг в перед и 2 по бокам
        step(1, 2, current);

        // проверка 2 шага в перед и 1 по бокам
        step(2, 1, current);

        // шаг 3-ий прыжок на 3 клетки в перед
        step(3, 0, current);

        // проверка достигли ли мы в финишную точку, если true то добаляем точку в список пути, false - пропускаем
        if (current.allListNode().contains(finish)) {
            temp = current.allListNode().get(current.allListNode().indexOf(finish));    // поиск финишного узла
            path.addLast(temp);     // добавелние финишного узла в список пути

            // добавление путей в результирующий список.
            listPath.add(new Path(path.size() - 1, printPath(path)));

            // удаление последнего элемента
            path.pollLast();
            return;
        }

        // проверяется  есть ли в списке элементы, если есть вызывается сетод added() (рекурсия).
        if (!current.allListNode().isEmpty()) {
            for (Node node : current.allListNode()) {
                added(node);
                path.pollLast();
            }
        }

    }

    /**
     * метод формирует строку пути
     * @param listPath список
     * @return строку пути
     */
    private String printPath(Deque listPath) {
        StringBuilder sb = new StringBuilder();
        for (Object o : listPath) {
            sb.append(o + " ");
        }
        return sb.toString().trim();
    }

    /**
     * метод печатает список путей
     */
    private void printList() {
        Collections.sort(listPath);
        if (listPath.size() != 0) {
            int number = listPath.get(0).getCount();
            for (Path path : listPath) {
                if (number >= path.getCount()) {
                    System.out.println(path);
                }
            }
        } else {
            System.out.println("Невозможно добраться от исходного положения в конечное");
            return;
        }
    }

    /**
     * метод проверяет прыжок лягушки, если true - создается следующая точка (координаты).
     * @param forward прыжко в перед
     * @param leftRight прыжок в лево и право
     * @param current текущая позиция (текущие координаты)
     */
    private void step(int forward, int leftRight, Node current) {
        int startX = current.getX();
        int startY = current.getY();
        int finishY = finish.getY();
        Node temp = null;

        if (startY <= finishY) {
            if ((startY + forward) <= finishY) {
                if (startX + leftRight <= 10) {
                    temp = new Node(startX + leftRight, startY + forward);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }

                if ((startX - leftRight) >= forward && leftRight != 0) {
                    temp = new Node(startX - leftRight, startY + forward);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }

            }
            // прошол узел 16-1 сектор
        } else {
            if (startY + forward <= 16) {
                if ((startX + leftRight) <= 10) {
                    temp = new Node(startX + leftRight, startY + forward);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }
                if ((startX - leftRight) >= forward  && leftRight != 0) {
                    temp = new Node(startX - leftRight, startY + forward);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }
            } else if ((startY + forward) % 16 <= finishY) {
                if ((startX + leftRight) <= 10) {
                    temp = new Node(startX + leftRight, (startY + forward) % 16);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }
                if ((startX - leftRight) >= forward  && leftRight != 0) {
                    temp = new Node(startX - leftRight, (startY + forward) % 16);
                    if (!tree.contains(temp) && temp != null) {
                        current.addNode(temp);
                    }
                }
            }

        }
    }
}
