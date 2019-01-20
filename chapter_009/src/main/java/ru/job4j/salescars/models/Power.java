package ru.job4j.salescars.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 17.01.2019
 */
@Entity
@Table(name = "POWER")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_POWER")
    private int namePower;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "power")
    @JsonBackReference
    private List<Car> cars;

    public Power() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNamePower() {
        return namePower;
    }

    public void setNamePower(int namePower) {
        this.namePower = namePower;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
