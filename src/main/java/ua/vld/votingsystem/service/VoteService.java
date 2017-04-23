package ua.vld.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ua.vld.votingsystem.model.Vote;
import ua.vld.votingsystem.repository.VoteRepository;

import java.time.LocalTime;

import static ua.vld.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    private static final LocalTime ENDED_TIME = LocalTime.parse("11:00");

    private static void checkTime(){
        if(LocalTime.now().isAfter(ENDED_TIME)){
            throw new DataIntegrityViolationException("Vote time restriction");
        }
    }

    public Vote save(Vote vote, int userId, int restaurantId){
        checkTime();
        return voteRepository.save(vote, userId, restaurantId);
    }

    public Vote getCurrent(int userId){
        return voteRepository.getCurrent(userId);
    }
}
