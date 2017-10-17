package ru.job4j.oop;


/**
 * Class Diagnoz.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Diagnoz {

    /**
     * диагноз.
     */
    private String diagniz;

    /**
     * возвращает диагноз пациента.
     * @return диагноз
     */
    public String getDiagniz() {
        return diagniz;
    }

    /**
     * устанавливает диагноз пациента.
     * @param diagniz диагноз
     */
    public void setDiagniz(String diagniz) {
        this.diagniz = diagniz;
    }
}
