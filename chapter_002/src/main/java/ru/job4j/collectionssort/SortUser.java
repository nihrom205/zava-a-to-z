package ru.job4j.collectionssort;

import java.util.*;

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
     * @param list список пользователей
     * @return отсортированное множество
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * метод сортирует пользователей по длине имени.
     * @param list не отсортированный список пользователей
     * @return отсортированный список
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * метод сортирует пользователй по имени, если имена одинаковые,
     * то сортируется по возрасту.
     * @param list неотсортированный список пользователей
     * @return отсортированный список пользователей
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rez =  o1.getName().compareTo(o2.getName());
                return rez != 0 ? rez : Integer.compare(o1.getAge(), o2.getAge()) ;
            }
        });
        return list;
    }
}
