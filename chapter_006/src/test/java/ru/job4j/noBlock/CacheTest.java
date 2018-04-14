package ru.job4j.noBlock;

import org.junit.After;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 08.04.2018
 */
public class CacheTest {


    @After
    public void after() {

    }

    @Test
    public void whenAddedStoreAndEditNameThenEditingName() {
        Cache cache = new Cache();
        Model model1 = new Model(1, "chach-01");
        Model model2 = new Model(2, "chach-02");
        Model model3 = new Model(3, "chach-03");

        cache.add(model1);
        cache.add(model2);
        cache.add(model3);

        Model model2_new = new Model(2, "bla-bla-bla");
        Model model2_old = new Model(2, "oldData");
        model2_old.setVersion(4);

        Model rezult = cache.update(model2_new);
        cache.update(model2_old);

        model2_new.setName("temp");

        cache.delete(model3);
        assertThat(rezult.getName(),is("bla-bla-bla"));


    }
}