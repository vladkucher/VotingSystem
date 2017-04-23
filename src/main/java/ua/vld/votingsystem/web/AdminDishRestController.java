package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vld.votingsystem.model.Dish;
import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.service.DishService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ua.vld.votingsystem.util.ValidationUtil.checkIdConsistent;
import static ua.vld.votingsystem.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/admin/restaurants/{restaurantId}/dishes";

    @Autowired
    public DishService dishService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@Valid @RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId){
        log.info("create {} for restaurant with id={}", dish, restaurantId);
        checkNew(dish);
        Dish created = dishService.save(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getRestaurant().getId(),created.getId())
                .toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody Dish dish, @PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId){
        log.info("update {} for restaurant with id={}", dish, restaurantId);
        checkIdConsistent(dish,id);
        dishService.update(dish,restaurantId);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId){
        log.info("delete dish with id=" + id);
        dishService.delete(id,restaurantId);
    }

    @GetMapping
    public List<Dish> getAllToday(@PathVariable("restaurantId") int restaurantId){
        log.info("getAll");
        return dishService.getAllToday(restaurantId);
    }

    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId){
        log.info("get "+id);
        return dishService.get(id,restaurantId);
    }


}
