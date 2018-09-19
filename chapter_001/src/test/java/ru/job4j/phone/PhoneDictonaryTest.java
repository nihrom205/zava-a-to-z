package ru.job4j.phone;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class Тестирования.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 19.09.18
 */
public class PhoneDictonaryTest {
    @Test
    public void whenAddPersonThenFindToKey() {
        List<Persone> result;
        PhoneDictonary phone = new PhoneDictonary();
        phone.add(new Persone("Alexey", "Rostorguev", "2-12-22", "Ekaterinbyrg"));
        phone.add(new Persone("Roex", "Yalov", "2-12-33", "Zarechniy"));
        phone.add(new Persone("Alexey", "Borovokov", "2-22-44", "Asbest"));
        phone.add(new Persone("Oleg", "Romanov", "2-11-11", "Asbest"));

        result = phone.find("Ro");
        assertThat(result.size(), is(3));
    }

}