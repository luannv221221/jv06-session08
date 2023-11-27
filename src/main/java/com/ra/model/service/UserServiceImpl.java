package com.ra.model.service;

import com.ra.model.dao.UserDAO;
import com.ra.model.dao.UserDAOImpl;
import com.ra.model.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean saveOrUpdate(User user) {
        return userDAO.saveOrUpdate(user);
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
