package ua.vld.votingsystem.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vld.votingsystem.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()){
            em.persist(restaurant);
            return restaurant;
        }else {
            return em.merge(restaurant);
        }
    }

    public Restaurant getToday(int id) {
        List<Restaurant> restaurants = em.createQuery("select distinct r from Restaurant r, Dish d WHERE d.date=:date and r.id=:id",Restaurant.class)
                .setParameter("id",id)
                .setParameter("date", LocalDate.now())
                .getResultList();
        return DataAccessUtils.singleResult(restaurants);
    }

    @Transactional
    public boolean delete(int id) {
        return em.createQuery("delete from Restaurant r where r.id=:id").setParameter("id",id).executeUpdate()!=0;
    }

    /*public List<Restaurant> getAll() {
        return em.createQuery("select r from Restaurant r",Restaurant.class).getResultList();
    }*/

    public List<Restaurant> getAllToday() {
        return em.createQuery("select distinct r from Restaurant r, Dish d WHERE d.date=:date",Restaurant.class).setParameter("date", LocalDate.now()).getResultList();
    }
}
