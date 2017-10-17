package ru.job4j.oop;

/**
 * Class Parents.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Parents {

    /**
     * переменная список Родителей.
     */
    private String listParents;

    /**
     * еременная инфо.
     */
    private String info;

    /**
     * метод предоставляет список родителей.
     * @return родители
     */
    public String getListParents() {
        return listParents;
    }

    /**
     * метод устанавливает список родителей.
     * @param listParents родители
     */
    public void setListParents(String listParents) {
        this.listParents = listParents;
    }

    /**
     * метод предоставляет информацию по собранию.
     * @return информация
     */
    public String getInfo() {
        return info;
    }

    /**
     * метод устанавливает информацию по собранию.
     * @param info информация
     */
    public void setInfo(String info) {
        this.info = info;
    }
}
