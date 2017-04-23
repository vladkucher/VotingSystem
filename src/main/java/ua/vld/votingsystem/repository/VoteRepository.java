package ua.vld.votingsystem.repository;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vld.votingsystem.model.Restaurant;
import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.model.Vote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class VoteRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Vote save(Vote vote, int userId, int restaurantId) {
        vote.setRestaurant(em.getReference(Restaurant.class,restaurantId));
        vote.setUser(em.getReference(User.class,userId));
        System.out.println(vote);
        List<Vote> todayVoteList = em.createQuery("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:today",Vote.class)
                .setParameter("userId",userId)
                .setParameter("today", LocalDate.now())
                .getResultList();
        Vote todayVote = DataAccessUtils.singleResult(todayVoteList);
        if(todayVote==null){
            em.persist(vote);
            return vote;
        }else{
            vote.setId(todayVote.getId());
            return em.merge(vote);
        }
    }

    public Vote getCurrent(int userId){
        List<Vote> votes = em.createQuery("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date",Vote.class)
                .setParameter("userId",userId)
                .setParameter("date",LocalDate.now())
                .getResultList();
        return DataAccessUtils.singleResult(votes);
    }
}
