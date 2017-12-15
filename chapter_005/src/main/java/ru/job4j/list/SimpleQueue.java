package ru.job4j.list;

/**
 * Class SimpleQueue.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.12.2017
 */
public class SimpleQueue<E> extends SimpleList<E> {

    /**
     * удаляет и возвращает элемент из начала колекции.
     * @return элемент
     */
    public E poll() {
        E rezult = first.eData;
        first = first.next;
        return rezult;
    }

    /**
     * метод добавляет в начало колекции элемент .
     * @param value елемент для сохранения в колекции.
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
}
