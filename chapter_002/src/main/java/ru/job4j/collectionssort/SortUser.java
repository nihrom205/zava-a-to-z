package ru.job4j.collectionssort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 12.11.2017
 */
public class SortUser {
    /**
     * метод из листа помещает в set и сортирует по полю age.
     * @param list
     * @return
     */
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>(list);
        return set;
    }
}
