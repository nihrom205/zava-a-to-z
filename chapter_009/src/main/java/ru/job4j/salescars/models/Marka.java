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
@Table(name = "MARKA")
public class Marka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_MARKA")
    private String nameMarka;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "marka")
    @JsonBackReference
    private List<Car> cars;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "marka")
//    @JsonBackReference
//    private List<Model> models;

    public Marka() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMarka() {
        return nameMarka;
    }

    public void setNameMarka(String nameMarka) {
        this.nameMarka = nameMarka;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

//    public List<Model> getModels() {
//        return models;
//    }
//
//    public void setModels(List<Model> models) {
//        this.models = models;
//    }
}
