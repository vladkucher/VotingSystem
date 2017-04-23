package ua.vld.votingsystem.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "votes")
public class Vote extends BaseEntity{
    /*@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)*/
    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Vote(){
    }

    public Vote(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id="+getId()+
                ", date=" + date +
                ", user=" + user +
                ", restaurant=" + restaurant +
                '}';
    }

}
