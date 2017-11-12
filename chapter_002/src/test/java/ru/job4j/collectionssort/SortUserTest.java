package ru.job4j.collectionssort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 12.11.2017
 */
public class SortUserTest {
    @Test
    public void whenListUserThenSetSortedUserDataFieldAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("zuma", 60),
                                    new User("petr", 30),
                                    new User("alex", 12),
                                    new User("olga", 65)));

        Set<User> except = new TreeSet<>();
        except.addAll(Arrays.asList(new User("alex", 12),
                                    new User("petr", 30),
                                    new User("zuma", 60),
                                    new User("olga", 65)));

        Set<User> rezult;

        rezult = sortUser.sort(list);

        assertThat(except, is(rezult));
    }
}
