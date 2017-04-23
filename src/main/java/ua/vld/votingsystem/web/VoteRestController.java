package ua.vld.votingsystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.vld.votingsystem.AuthorizedUser;
import ua.vld.votingsystem.model.Vote;
import ua.vld.votingsystem.service.VoteService;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "api/profile/votes";

    @Autowired
    private VoteService voteService;

    @GetMapping
    public Vote get(){
        log.info("get vote for User with id="+AuthorizedUser.id());
        return voteService.getCurrent(AuthorizedUser.id());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Vote> createWithLocation(@PathVariable("id") int restaurantId){
        log.info("create vote for User with id={} and restaurantId={}",AuthorizedUser.id(),restaurantId);
        Vote vote = new Vote(LocalDate.now());
        Vote created = voteService.save(vote,AuthorizedUser.id(),restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL)
                .buildAndExpand().toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
