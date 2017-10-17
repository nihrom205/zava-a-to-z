package ru.job4j.oop;

/**
 * Class Student.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Student {

    /**
     * переменная наука.
     */
    private String science;

    /**
     * переменная имя.
     */
    private String name;

    /**
     * метод предоставляет знания студента.
     * @return занания
     */
    public String getScience() {
        return science;
    }

    /**
     * метод устанавлиает знания студ.
     * @param science знания
     */
    public void setScience(String science) {
        this.science = science;
    }

    /**
     * метод предоставляет имя студента.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * метод устанавливает имя студента.
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }
}
