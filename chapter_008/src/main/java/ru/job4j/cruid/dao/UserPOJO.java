package ru.job4j.cruid.dao;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 22.11.2018
 */
public class UserPOJO {
    String lastName;
    String firstNmae;
    String gender;
    String description;

    public UserPOJO() {
    }

    public UserPOJO(String lastName, String firstNmae, String gender, String description) {
        this.lastName = lastName;
        this.firstNmae = firstNmae;
        this.gender = gender;
        this.description = description;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
