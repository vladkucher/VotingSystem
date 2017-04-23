package ua.vld.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vld.votingsystem.model.Dish;
import ua.vld.votingsystem.repository.DishRepository;

import java.util.List;

import static ua.vld.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public Dish save(Dish dish, int restaurantId){
        return dishRepository.save(dish, restaurantId);
    }

    public Dish update(Dish dish, int restaurantId){
        return checkNotFoundWithId(dishRepository.save(dish,restaurantId),dish.getId(), restaurantId);
    }

    public Dish get(int id, int restaurantId){
        return checkNotFoundWithId(dishRepository.get(id,restaurantId),id ,restaurantId);
    }

    public void delete(int id, int restaurantId){
        checkNotFoundWithId(dishRepository.delete(id,restaurantId), id, restaurantId);
    }

    public List<Dish> getAllToday(int restaurantId){
        return dishRepository.getAllToday(restaurantId);
    }
}
