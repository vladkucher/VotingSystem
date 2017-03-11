package ua.vld.votingsystem.repository;

import org.springframework.stereotype.Repository;
import ua.vld.votingsystem.model.Role;
import ua.vld.votingsystem.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    public boolean delete(int id) {
        return true;
        //return em.createNamedQuery("DELETE FROM User u WHERE u.id=:id").setParameter("id", id).executeUpdate() != 0;
    }

    public User get(int id) {
        return null;
    }

    public User getByEmail(String email) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

}
