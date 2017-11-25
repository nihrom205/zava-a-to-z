package ru.job4j.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 11.11.2017
 */
public class PerformanceArray {
    public long add(Collection<String> collection, int amount) {
        String[] massStr = new String[]{"Shehas", "very", "pleasant", "smile", "andasoft", "hairandbrown", "eyes", "Myname", "isJessica", "Iameleven"};
        long startL = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            int num = 0 + (int) (Math.random() * 10);
            collection.add(massStr[num] + "-" + i);
        }

        return System.currentTimeMillis() - startL;
    }

    public long delete(Collection<String> collection, int amount) {
        Iterator<String> iterator = collection.iterator();
        TreeSet<String> aa = new TreeSet<>();
        int count = 0;
        long startL = System.currentTimeMillis();
        while (iterator.hasNext()) {
            if (count  != amount) {
                iterator.next();
                iterator.remove();
                count++;
            } else {
                break;
            }
        }

        return System.currentTimeMillis() - startL;
    }
}
