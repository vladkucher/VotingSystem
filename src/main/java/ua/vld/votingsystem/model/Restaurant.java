package ua.vld.votingsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

    public Restaurant(){
    }

    public Restaurant(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
