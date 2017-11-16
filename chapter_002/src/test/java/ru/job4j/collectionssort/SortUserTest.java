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
                                    new User("olga", 60)));

        Set<User> except = new TreeSet<>();
        except.addAll(Arrays.asList(new User("alex", 12),
                                    new User("petr", 30),
                                    new User("zuma", 60),
                                    new User("olga", 60)));

        Set<User> rezult;

        rezult = sortUser.sort(list);

        assertThat(except, is(rezult));
    }

    // проверка сортировки по длине имени
    @Test
    public void whenListSortNameLengthThenSortedName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("Valerya", 60),
                                    new User("Andrey", 30),
                                    new User("Alexa", 12),
                                    new User("olga", 65)));

        List<User> except = new ArrayList<>();
        except.addAll(Arrays.asList(new User("olga", 65),
                                    new User("Alexa", 12),
                                    new User("Andrey", 30),
                                    new User("Valerya", 60)));

        List<User> rezult;
        rezult = sortUser.sortNameLength(list);
        assertThat(except, is(rezult));
    }

    /**
     * проверка сортировки по 2 параметрам (имя и возраст),
     * если имя совпадают то учитывается возраст.
     */
    @Test
    public void whenLIstSortAllFieldThenListSorted() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("Valerya", 10),
                                  new User("Andrey", 30),
                                  new User("Olga", 12),
                                  new User("Alga", 65),
                                  new User("Alga", 55)
        ));

        List<User> except = new ArrayList<>();
        except.addAll(Arrays.asList(new User("Alga", 55),
                                    new User("Alga", 65),
                                    new User("Andrey", 30),
                                    new User("Olga", 12),
                                    new User("Valerya", 10)));

        List<User> rezult;
        rezult = sortUser.sortByAllFields(list);
        assertThat(except, is(rezult));
    }

}
