package ua.vld.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vld.votingsystem.model.Restaurant;
import ua.vld.votingsystem.repository.RestaurantRepository;

import java.util.List;

import static ua.vld.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant save(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant){
        return checkNotFoundWithId(restaurantRepository.save(restaurant),restaurant.getId());
    }

    public void delete(int id){
        checkNotFoundWithId(restaurantRepository.delete(id),id);
    }

    public Restaurant getToday(int id){
        return checkNotFoundWithId(restaurantRepository.getToday(id),id);
    }

    public List<Restaurant> getAllToday(){
        return restaurantRepository.getAllToday();
    }
}
