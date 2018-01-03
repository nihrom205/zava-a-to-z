package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class SimpleStack.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.12.2017
 */
public class SimpleStack<E> extends SimpleList<E> {

    /**
     * метод добавляет в начало колекции элемента.
     * @param value элемент
     */
    public void push(E value) {
        Node<E> newLink = new Node<E>(index++, value);
        if (first == null) {
            first = newLink;
        } else {
            newLink.next = first;
            first = newLink;
        }
    }

    /**
     * удаляет и возвращает элемент из начала колекции.
     * @return возвращает элемен.
     */
    public E poll() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E rezult = first.eData;
        first = first.next;
        return rezult;
    }


}
