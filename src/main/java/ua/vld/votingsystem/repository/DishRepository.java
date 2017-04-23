package ua.vld.votingsystem.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vld.votingsystem.model.Dish;
import ua.vld.votingsystem.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(em.getReference(Restaurant.class,restaurantId));
        if(dish.isNew()){
            em.persist(dish);
            return dish;
        }else {
            return em.merge(dish);
        }
    }

    public Dish get(int id, int restaurantId) {
        List<Dish> dishes = em.createQuery("SELECT d FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId",Dish.class)
                .setParameter("id",id)
                .setParameter("restaurantId",restaurantId)
                .getResultList();
        return DataAccessUtils.singleResult(dishes);
    }

    @Transactional
    public boolean delete(int id, int restaurantId) {
        return em.createQuery("DELETE FROM Dish WHERE id=:id AND restaurant.id=:restaurantId")
                .setParameter("id",id)
                .setParameter("restaurantId",restaurantId)
                .executeUpdate()!=0;
    }

    public List<Dish> getAllToday(int restaurantId){
        return em.createQuery("SELECT d FROM Dish d WHERE d.restaurant.id=:id AND d.date=:date",Dish.class)
                .setParameter("id",restaurantId)
                .setParameter("date", LocalDate.now())
                .getResultList();
    }
}
