package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.service.UserService;
import ua.vld.votingsystem.service.UserServiceImpl;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ua.vld.votingsystem.util.ValidationUtil.checkIdConsistent;
import static ua.vld.votingsystem.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/admin/users";

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        log.info("getAll");
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable int id){
        log.info("get " + id);
        return userService.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@Valid @RequestBody User user){
        log.info("create " + user);
        checkNew(user);
        User created = userService.save(user);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody User user, @PathVariable("id") int id){
        log.info("update " + user);
        checkIdConsistent(user,id);
        userService.update(user);
    }

    @DeleteMapping(value = "/{id]")
    public void delete(@PathVariable("id") int id){
        log.info("delete " + id);
        userService.delete(id);
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByEmail(@RequestParam("email") String email) {
        log.info("getByEmail " + email);
        return userService.getByEmail(email);
    }

}
