package ru.job4j.oop;

/**
 * Class Teacher.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Teacher extends Profession {

    /**
     * переменная обучение.
     */
    private String subject;

    /**
     * метод обучает студентов.
     *
     * @param student студент
     * @return обученный студент
     */
    public Student education(Student student) {
        student.setScience("Учитель " + this.getName() + " обучает" + student.getName());
        return student;
    }

    /**
     * метод проводит собрание.
     *
     * @param parents родители
     * @return родители с полученной информацией
     */
    public Parents meeting(Parents parents) {
        parents.setInfo("Учитель " + this.getName() + " проводит собрание с родителями " + parents.getListParents());
        return parents;
    }
}
