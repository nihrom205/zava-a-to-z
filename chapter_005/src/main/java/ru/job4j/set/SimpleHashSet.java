package ru.job4j.set;

/**
 * Class Set на базе хэш-таблицы.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
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
     * @return treu - добавлено, false - не добавлено в массив.
     */
    @Override
    public boolean add(E e) {
        boolean isAdd = false;

        // проверка есть ли элемент в колекции,
        // если true то пропускаем, если false то записываем
        if (!contains(e)) {
            if (count == mass.length) {
                Node[] newMass = new Node[2 * mass.length];
                System.arraycopy(mass, 0, newMass, 0, mass.length);
                mass = newMass;
            }
            int hCode = hf(e);
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
        boolean isNotEmpty = false; // есть искомый элемент (false - нет)
        if (isEmpty(e) != -1)
            isNotEmpty = true;
        return isNotEmpty;
    }

    /**
     * удаление элемента из массива.
     * @param e элемент
     * @return true - удален, иначе - false
     */
    @Override
    public boolean remove(E e) {
        boolean isRemove = false;
        int rezult = isEmpty(e);
        if (rezult != -1) {
            mass[rezult] = null;
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
     * метод генерирует hashCode, от String и Integer
     * @param e
     * @return
     */
    private int hf(E e) {
        int hash = 0;
        int HashCode = 31;
        String data = "";

        if (e instanceof String) {
            data = (String) e;
        } else if (e instanceof Integer) {
            data = String.valueOf((Integer) e);
        } else {

        }
        for (int i = 0; i < data.length(); i++) {
            hash += ((HashCode << 5) + HashCode) + data.codePointAt(i);
        }
        return hash;
    }

    /**
     * метод проверяет есть ли элемент в массиве, если есть возвращает индекс, иначе -1;
     * @param e элемент
     * @return индекс элемента
     */
    private int isEmpty(E e) {
        int rezult = -1;
        int hash = hf(e);
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != null && mass[i].key == hash) {
                rezult = i;  // нашли искомый элемент (true)
                break;
            }

        }
        return rezult;
    }
}
