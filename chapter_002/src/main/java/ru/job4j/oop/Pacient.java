package ru.job4j.oop;

/**
 * Class Pacient.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Pacient {

    /**
     * переменная nama имя.
     */
    private String name;
    /**
     * переменная state состояние.
     */
    private String state;

    /**
     * возвращает имя пациента.
     * @return имя пациента
     */
    public String getName() {
        return name;
    }

    /**
     * устанавливает имя пациента.
     * @param name имя пациента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * возвращает состояние пациента.
     * @return состояние пациента
     */
    public String getState() {
        return state;
    }

    /**
     * устанавливает состояние пациента.
     * @param state состояние пациента
     */
    public void setState(String state) {
        this.state = state;
    }
}
