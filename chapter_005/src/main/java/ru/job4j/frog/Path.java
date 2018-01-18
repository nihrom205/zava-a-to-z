package ru.job4j.frog;

/**
 * Class Path.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.01.2018
 */
public class Path implements Comparable<Path> {
    private int count;
    private String pathStr;

    // Конструктор
    public Path(int count, String pathStr) {
        this.count = count;
        this.pathStr = pathStr;
    }

    // кол-во шагов
    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Path path = (Path) o;

        return count == path.count;
    }

    @Override
    public int hashCode() {
        return count;
    }

    @Override
    public int compareTo(Path o) {
        return this.count - o.count;
    }

    @Override
    public String toString() {
        return "Path{" +
                "count=" + count +
                ", " + pathStr  +
                '}';
    }
}
