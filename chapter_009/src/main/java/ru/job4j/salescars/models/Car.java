package ru.job4j.salescars.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.persistence.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 09.01.2019
 */
@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BODY_ID", nullable = false)
    @JsonManagedReference
    private Body body;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LITRES_ID", nullable = false)
    @JsonManagedReference
    private Litres litres;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POWER_ID", nullable = false)
    @JsonManagedReference
    private Power power;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MARKA_ID", nullable = false)
    @JsonManagedReference
    private Marka marka;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODEL_ID")
    @JsonManagedReference
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonManagedReference
    private User user;

    @Column(name = "IS_SOLD", nullable = false)
    private Boolean isSold = false;

    @Column(name = "PICTURE")
    private String picture = "img/nofoto.png";

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Litres getLitres() {
        return litres;
    }

    public void setLitres(Litres litres) {
        this.litres = litres;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

//    public void setPicture(Integer picture) {
//        this.picture = picture;
//    }


}
