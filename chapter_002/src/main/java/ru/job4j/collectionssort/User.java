package ru.job4j.collectionssort;

/**
 * Class User.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 12.11.2017
 */
public class User implements Comparable<User>{
    private String name;
    private int age;

    /**
     * Конструктор.
     *
     * @param name имя пользлвателя
     * @param age возраст пользователя
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // геттеры и сеттеры   ---------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // --------------------------------------

    @Override
    public int compareTo(User o) {
        if (this.age == o.age) {
            return 0;
        } else if (this.age > o.age) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
