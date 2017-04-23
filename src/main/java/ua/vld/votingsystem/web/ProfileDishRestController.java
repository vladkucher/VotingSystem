package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vld.votingsystem.model.Dish;
import ua.vld.votingsystem.service.DishService;

import java.util.List;

@RestController
@RequestMapping(value = ProfileDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileDishRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/profile/restaurants/{restaurantId}/dishes";

    @Autowired
    public DishService dishService;

    @GetMapping
    public List<Dish> getAllToday(@PathVariable("restaurantId") int restaurantId){
        log.info("getAll");
        return dishService.getAllToday(restaurantId);
    }
}
