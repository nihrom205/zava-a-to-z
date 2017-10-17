package ru.job4j.oop;

/**
 * Class Smeta.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Smeta {

    /**
     * название здания.
     */
    private String nameBuilding;

    /**
     * метод предоставляет имя здания.
     * @return имя здания
     */
    public String getNameBuilding() {
        return nameBuilding;
    }

    /**
     * метод устанавливает имя здания.
     * @param nameBuilding имя здания
     */
    public void setNameBuilding(String nameBuilding) {
        this.nameBuilding = nameBuilding;
    }
}
