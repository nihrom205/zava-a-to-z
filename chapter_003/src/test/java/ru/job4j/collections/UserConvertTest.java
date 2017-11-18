package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Описание.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 12.11.2017
 */
public class UserConvertTest {
    @Test
    public void whenListUsersThenMapUsers() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        HashMap<Integer, User> rezult = new HashMap<>();
        list.addAll(Arrays.asList(new User(100, "Alexey", "Yekaterinburg"),
                                new User(101, "Ivan", "Samara"),
                                new User(102, "Sandra", "Kerch"),
                                new User(103, "Olga", "Vladivostok")));

        HashMap<Integer, User> except = new HashMap<>();
        except.put(100, new User(100, "Alexey", "Yekaterinburg"));
        except.put(101, new User(101, "Ivan", "Samara"));
        except.put(102, new User(102, "Sandra", "Kerch"));
        except.put(103, new User(103, "Olga", "Vladivostok"));

        rezult = userConvert.process(list);
        assertThat(rezult, is(except));
    }
}
