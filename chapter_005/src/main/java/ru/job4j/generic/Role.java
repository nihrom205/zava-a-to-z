package ru.job4j.generic;

/**
<<<<<<< HEAD
 * Описание.
=======
 * класс role.
>>>>>>> origin/master
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 02.12.2017
 */
public class Role extends Base {
    private String id = "";

    @Override
    String getId() {
        return this.id;
    }

    @Override
    void setId(String id) {
        this.id = id;
    }
}
