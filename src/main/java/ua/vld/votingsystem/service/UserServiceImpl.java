package ua.vld.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ua.vld.votingsystem.AuthorizedUser;
import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.repository.UserRepository;
import ua.vld.votingsystem.to.UserTo;
import ua.vld.votingsystem.util.UserUtil;
import ua.vld.votingsystem.util.exception.NotFoundException;

import java.util.List;

import static ua.vld.votingsystem.util.UserUtil.prepareToSave;
import static ua.vld.votingsystem.util.UserUtil.updateFromTo;
import static ua.vld.votingsystem.util.ValidationUtil.checkNotFound;
import static ua.vld.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService ,UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(prepareToSave(user));
    }

    public User update(User user){
        return userRepository.save(prepareToSave(user));
    }

    @Transactional
    public void update(UserTo userTo) {
        User user = updateFromTo(get(userTo.getId()), userTo);
        userRepository.save(prepareToSave(user));
    }

    public void delete(int id){
        checkNotFoundWithId(userRepository.delete(id),id);
    }

    public User get(int id){
        return checkNotFoundWithId(userRepository.get(id),id);
    }

    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.getByEmail(email.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(u);
    }
}
