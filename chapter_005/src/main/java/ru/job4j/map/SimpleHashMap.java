package ru.job4j.map;

/**
 * Class SimpleHashMap.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.12.2017
 */
public class SimpleHashMap<K, V> implements SimpleHashMapImpl<K, V> {
    private Node<K, V>[] mass;
    private int count = 0;

    public SimpleHashMap() {
        mass = new Node[100];
    }

    public SimpleHashMap(int value) {
        this.mass = new Node[value];
    }

    /**
     * метод добавляет Объект в массив и возвращает true - в случае успеха, иначе - false.
     * @param key ключь
     * @param value значение
     * @return true - объект помещен в массив, иначе false
     */
    @Override
    public boolean insert(K key, V value) {
        boolean isAdd = false;
        // проверка заполнен ли массив, true - увеличивается массив в 2 раза.
        if (count == mass.length) {
            enlarge();
        }
        if (get(key) == null) {
            int hash = key.hashCode();
            int position = hash % mass.length;
            mass[position] = new Node<>(hash, key, value);
            count++;
            isAdd = true;
        }

        return isAdd;
    }

    /**
     * метод возвращает значение по ключу
     * @param key ключь
     * @return значение
     */
    @Override
    public V get(K key) {
        V result = null;
        int position = key.hashCode() % mass.length;
        if (mass[position] != null) {
            result = mass[position].getValue();
        }
        return result;
    }

    /**
     * метод удаляет элемент из массива по колючу, true - удален, иначе - false.
     * @param key ключь
     * @return true - удален, иначе - false
     */
    @Override
    public boolean delete(K key) {
        boolean isDel = false;
        int position = key.hashCode() % mass.length;
        if (mass[position] != null) {
            mass[position] = null;
            isDel = true;
        }
        return isDel;
    }

    /**
     * Метод для увеличения массива.
     */
    private void enlarge() {
        Node[] newMass = new Node[2 * mass.length];
        int position = 0;
        int newArraySize = newMass.length;
        for (int i = 0; i < mass.length; i++) {
            position = mass[i].getKey().hashCode() % newArraySize;
            newMass[position] = mass[i];
        }
        mass = newMass;
    }

    /**
     * Объект хранения в массиве.
     * @param <K> ключь
     * @param <V> значение
     */
    private class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
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
}
