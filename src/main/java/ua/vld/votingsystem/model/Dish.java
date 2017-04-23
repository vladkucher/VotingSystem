package ua.vld.votingsystem.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "dishes")
public class Dish extends NamedEntity {
    @NotNull
    @Column(name = "price")
    private Double price;

    /*@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)*/
    @Column(name = "date")
    @NotNull
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate date;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, Double price, LocalDate date, Restaurant restaurant) {
        super(id, name);
        this.price = price;
        this.date = date;
        this.restaurant = restaurant;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", restaurant=" + restaurant +
                '}';
    }
}
