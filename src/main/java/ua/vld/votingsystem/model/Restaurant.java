package ua.vld.votingsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {

    //@LazyCollection(LazyCollectionOption.FALSE)
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Dish> dishes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Vote> votes;*/

    public Restaurant(){
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
