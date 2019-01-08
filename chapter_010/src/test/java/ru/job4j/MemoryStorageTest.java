package ru.job4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 29.12.2018
 */
public class MemoryStorageTest {

    @Test
    public void whenAddtoMemory() {
        MemoryStorage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

    @Test
    public void whenLoadContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        assertNotNull(memory);
    }

    @Test
    public void whenLoadContextDepends() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User());
        assertNotNull(storage);
    }

    @Test
    public void whenAddUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User("1", "alex"));
        assertThat(storage.getAll().size(), is(1));
    }

    @Test
    public void whenDeleteUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User("1", "alex"));
        storage.add(new User("2", "oleg"));
        storage.add(new User("3", "natalya"));
        storage.delete(new User("1", "alex"));
        assertThat(storage.getAll().size(), is(2));
    }

    @Test
    public void whenUpdateUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User("1", "alex"));
        storage.update(new User("1", "test"));
        assertThat(storage.getAll().get(0).getName(), is("test"));
    }
}