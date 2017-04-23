package ua.vld.votingsystem.service;

import ua.vld.votingsystem.model.User;
import ua.vld.votingsystem.to.UserTo;
import ua.vld.votingsystem.util.exception.NotFoundException;

import java.util.List;


public interface UserService {
    User save(User user);

    User update(User user) throws NotFoundException;

    void update(UserTo userTo) throws NotFoundException;;

    void delete(int id) throws NotFoundException;;

    User get(int id) throws NotFoundException;;

    User getByEmail(String email) throws NotFoundException;;

    List<User> getAll();
}
