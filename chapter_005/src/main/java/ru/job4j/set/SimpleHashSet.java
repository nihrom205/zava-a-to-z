package ru.job4j.set;

/**
 * Class Set на базе хэш-таблицы.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.2
 * @since 18.12.17
 */
public class SimpleHashSet<E> implements SimpleHashTable<E> {
    // массив хранения элементов
    private Node<Integer, E>[] mass;
    // переменная для накопления кол-ва добавленных элементов в массив
    private int count = 0;

    /**
     * конструктор по умолчанию,
     * создает массив размером 100 элементов.
     */
    public SimpleHashSet() {
        mass = new Node[100];
    }

    /**
     * конструктор,
     * можно задать размер массива.
     * @param value
     */
    public SimpleHashSet(int value) {
        mass = new Node[value];
    }

    /**
     * метод добавления елементов в массив.
     * @param e елемент добавления
     * @return true - добавлено, false - не добавлено в массив.
     */
    @Override
    public boolean add(E e) {
        boolean isAdd = false;

        // проверка достигнут ли массив предела. true вызывается метод для увеличения массива, false - пропускается.
        if (count == mass.length) {
            enlarge();
        }

        // проверка есть ли элемент в колекции,
        // если false то пропускаем, если true то записываем
        if (!contains(e)) {
            int hCode = e.hashCode();
            hCode = (hCode < 0) ? Math.abs(hCode) : hCode;
            int position = hCode % mass.length;
            if (mass[position] == null) {
                mass[position] = new Node<>(hCode, e);
                count++;
                isAdd = true;
            }
        }
        return isAdd;
    }

    /**
     * метод проверяет, есть ли элемент в массиве.
     * @param e елемент
     * @return true есть элемент в массиве, иначе - false.
     */
    @Override
    public boolean contains(E e) {
        int position = e.hashCode() % mass.length;
        return (mass[position] != null) ? true : false;
    }

    /**
     * удаление элемента из массива.
     * @param e элемент
     * @return true - удален, иначе - false
     */
    @Override
    public boolean remove(E e) {
        boolean isRemove = false;
        if (contains(e)) {
            int position = e.hashCode() % mass.length;
            mass[position] = null;
            isRemove = true;
        }
        return isRemove;
    }

    /**
     * сдласс хранящийся в массиве
     * @param <K> ключ
     * @param <V> значение
     */
    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * метод увеличения массива в 2 раза от исходного.
     */
    private void enlarge() {
        Node[] newMass = new Node[2 * mass.length];
        int position = 0;
        int newArraySize = newMass.length;
        for (int i = 0; i < mass.length; i++) {
            position = mass[i].value.hashCode() % newArraySize;
            newMass[position] = mass[i];
        }
        mass = newMass;
    }
}
