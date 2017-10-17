package ru.job4j.oop;

/**
 * Class Doctor.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Doctor extends Profession {

    /**
     * метод, доктор проводи консультацию с пациентом.
     * @param pacient клас пациент
     * @return диагноз
     */
    public Diagnoz consultation(Pacient pacient) {
        Diagnoz diagnoz = new Diagnoz();
        diagnoz.setDiagniz("Доктор " + this.getName() + " провел обследование " + pacient.getName());
        return diagnoz;
    }

    /**
     * метод, доктор проводи лечение с пациентом.
     * @param pacient пациент
     * @return здоровый пациент)
     */
    public Pacient medication(Pacient pacient) {
        pacient.setState("Доктор " + this.getName() + " провел лечение " + pacient.getName());
        return pacient;
    }
}
