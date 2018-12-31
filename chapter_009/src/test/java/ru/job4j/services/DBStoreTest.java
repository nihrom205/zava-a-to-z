package ru.job4j.services;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 31.12.2018
 */
public class DBStoreTest {

    @Test
    public void whenInstanceDBSTORE() {
        assertNotNull(DBStore.getInstance());
    }
}