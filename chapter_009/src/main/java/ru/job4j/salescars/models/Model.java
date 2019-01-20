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
 * @since 15.01.2019
 */
@Entity
@Table(name = "MODEL")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_MODEL")
    private String nameModel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model")
    @JsonBackReference
    private List<Car> cars;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "MARKA_ID", nullable = false)
//    @JsonManagedReference
//    private Marka marka;

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
