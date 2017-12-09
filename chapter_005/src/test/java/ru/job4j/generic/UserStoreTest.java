package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Testing ClassUserStore and RoleStore.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 06.12.2017
 */
public class UserStoreTest {
    private Store store;
//    private SimpleArray<Role> simpleRole;

//    @Before
//    public void setUp() {
//        store = new UserStore();
//
////        simpleRole = new SimpleArray<>(10);
//    }

    @Test
    public void whenAddUserThenUsersStore() {
        store = new UserStore();
        User user1 = new User();
        user1.setId("1");
        User user2 = new User();
        user2.setId("2");
        User user3 = new User();
        user3.setId("3");
        store.add(user1).getId();
        store.add(user2).getId();
        store.add(user3).getId();

        User user = new User();
        user.setId("5");

        assertThat(store.add(user).getId(), is("5"));
    }

    @Test
    public void whenUpdateUserThenUserUpdatingStore() {
        store = new UserStore();
        User userU = new User();
        userU.setId("2");
        store.add(userU);
        assertThat(store.update(userU).getId(), is(userU.getId()));
    }

    @Test
    public void whenDeleteUserThenUsersDeletingToStore() {
        store = new UserStore();
        User user1 = new User();
        user1.setId("1");
        User user2 = new User();
        user2.setId("2");
        User user3 = new User();
        user3.setId("3");

        store.add(user1);
        store.add(user2);
        store.add(user3);

        assertThat(store.delete("3"), is(true));
    }

    @Test
    public void whenAddRoleThenRoleStore() {
        store = new RoleStore();
        Role role1 = new Role();
        role1.setId("1");
        Role role2 = new Role();
        role2.setId("2");
        Role role3 = new Role();
        role3.setId("3");
        store.add(role1).getId();
        store.add(role2).getId();
        store.add(role3).getId();

        Role role = new Role();
        role.setId("5");

        assertThat(store.add(role).getId(), is("5"));
    }

    @Test
    public void whenUpdateRoleThenUserUpdatingStore() {
        store = new RoleStore();
        Role roleU = new Role();
        roleU.setId("2");
        store.add(roleU);
        assertThat(store.update(roleU).getId(), is(roleU.getId()));
    }

    @Test
    public void whenDeleteRoleThenRolesDeletingToStore() {
        store = new RoleStore();
        Role role1 = new Role();
        role1.setId("1");
        Role role2 = new Role();
        role2.setId("2");
        Role role3 = new Role();
        role3.setId("3");

        store.add(role1);
        store.add(role2);
        store.add(role3);

        assertThat(store.delete("3"), is(true));
    }
}