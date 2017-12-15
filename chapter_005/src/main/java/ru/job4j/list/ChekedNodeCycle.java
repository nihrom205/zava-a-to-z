package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class ChekedNodeCycle.
 * клас проверяет на зацикленность список.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 16.12.2017
 */
public class ChekedNodeCycle {

    /**
     * етод проверяте на зацикленность, если есть цикл то true, иначе false,
     * если передать в метод null - выкинет исключение NoSuchElementException.
     * @param first список для проверки
     * @param <T> обобщенный тип
     * @return если есть цикл - true, иначе - false
     */
    static <T> boolean hasCycle(Node<T> first) {
        boolean rezult = false;
        if (first == null) {throw new NoSuchElementException();}
        Node<T> currentNode = first;
        Node<T> nextNode = null;
        if (currentNode.next != null) {
            nextNode = currentNode.next;
            while (!rezult) {
                if (currentNode == nextNode) {
                    rezult = true;
                } else if (nextNode.next != null && nextNode.next.next != null) {
                    currentNode = currentNode.next;
                    nextNode = nextNode.next.next;
                } else {
                    break;
                }
            }
        }
        return rezult;
    }
}
