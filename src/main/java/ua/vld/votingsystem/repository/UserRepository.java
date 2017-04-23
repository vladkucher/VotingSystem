package ua.vld.votingsystem.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vld.votingsystem.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Transactional
    public boolean delete(int id) {
        return em.createQuery("DELETE FROM User u WHERE u.id=:id").setParameter("id", id).executeUpdate() != 0;
    }

    public User get(int id) {
        return em.find(User.class, id);
    }

    public User getByEmail(String email) {
        List<User> users = em.createQuery("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1",User.class).setParameter(1, email).getResultList();
        return DataAccessUtils.singleResult(users);
    }

    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u ORDER BY u.name, u.email", User.class).getResultList();
    }

}
