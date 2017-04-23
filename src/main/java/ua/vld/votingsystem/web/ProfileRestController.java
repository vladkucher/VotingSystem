package ua.vld.votingsystem.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.vld.votingsystem.AuthorizedUser;
import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.service.UserService;
import ua.vld.votingsystem.service.UserServiceImpl;
import ua.vld.votingsystem.to.UserTo;

import javax.validation.Valid;

import static ua.vld.votingsystem.util.ValidationUtil.checkIdConsistent;

@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "/rest/profile";

    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        log.info("get " + AuthorizedUser.id());
        return userService.get(AuthorizedUser.id());
    }

    @DeleteMapping
    public void delete() {
        log.info("delete " + AuthorizedUser.id());
        userService.delete(AuthorizedUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody UserTo userTo) {
        log.info("update " + userTo);
        checkIdConsistent(userTo,AuthorizedUser.id());
        userService.update(userTo);
    }

}
