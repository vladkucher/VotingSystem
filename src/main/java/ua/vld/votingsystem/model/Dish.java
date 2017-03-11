package ua.vld.votingsystem.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "date_time")
    private Date dateTime;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, Double price, Date dateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateTime = dateTime;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateTime=" + dateTime +
                '}';
    }
}
