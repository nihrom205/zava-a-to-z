package ru.job4j.oop;

/**
 * Class Profession.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Profession {

    /**
     * пременные name имя.
     */
    private String name;

    /**
     * переменная age возраст.
     */
    private int age;

    /**
     * переменная education знание.
     */
    private String education;

    /**
     * конструктор по умолчанию.
     */
    public Profession() {
    }

    /**
     * конструктор.
     * @param name имя
     * @param age возраст
     * @param education  обучение
     */
    public Profession(String name, int age, String education) {
        this.name = name;
        this.age = age;
        this.education = education;
    }

    /**
     * возращает имя.
     * @return имя
     */
    public String getName() {
        return this.name;
    }

    /**
     * возвращает возраст.
     * @return возраст
     */
    public int getAge() {
        return this.age;
    }

    /**
     * возвращает знание.
     * @return знание
     */
    public String getEducation() {
        return this.education;
    }
}
