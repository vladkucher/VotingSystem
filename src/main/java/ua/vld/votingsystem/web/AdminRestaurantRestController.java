package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vld.votingsystem.model.Restaurant;
import ua.vld.votingsystem.service.RestaurantService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ua.vld.votingsystem.util.ValidationUtil.checkIdConsistent;
import static ua.vld.votingsystem.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/admin/restaurants";

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@Valid @RequestBody Restaurant restaurant){
        log.info("create " + restaurant);
        checkNew(restaurant);
        Restaurant created = restaurantService.save(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody Restaurant restaurant, @PathVariable("id") int id){
        log.info("update " + restaurant);
        checkIdConsistent(restaurant,id);
        restaurantService.update(restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        log.info("delete " + id);
        restaurantService.delete(id);
    }
}
