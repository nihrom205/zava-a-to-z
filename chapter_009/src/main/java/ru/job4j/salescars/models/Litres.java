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
@Table(name = "LITRES")
public class Litres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "VALUE_LITRS")
    private double litr;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "litres")
    @JsonBackReference
    private List<Car> cars;

    public Litres() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLitr() {
        return litr;
    }

    public void setLitr(double litr) {
        this.litr = litr;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
