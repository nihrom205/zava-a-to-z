package ru.job4j.storeuser;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class UserStoreTest.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.02.2018
 */
public class UserStoreTest {
    @Test
    public void whenAddUserThenTransferAmount() {
        UserStore store = new UserStore();
        store.add(new User(1, 400));
        store.add(new User(2, 200));
        store.add(new User(3, 1000));
        assertThat(store.update(new User(1, 1000)), is(true));
        assertThat(store.delete(new User(2, 200)), is(true));
        assertThat(store.transfer(1, 3, 400), is(true));
        System.out.println();
    }
}