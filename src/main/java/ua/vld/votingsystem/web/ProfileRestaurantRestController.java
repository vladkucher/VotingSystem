package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vld.votingsystem.model.Restaurant;
import ua.vld.votingsystem.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = ProfileRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestaurantRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/profile/restaurants";

    @Autowired
    public RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant getToday(@PathVariable("id") int id){
        log.info("get " + id);
        return restaurantService.getToday(id);
    }

    @GetMapping
    public List<Restaurant> getAllToday(){
        log.info("getAll");
        return restaurantService.getAllToday();
    }
}
