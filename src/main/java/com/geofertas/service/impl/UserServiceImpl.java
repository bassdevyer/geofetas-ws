package com.geofertas.service.impl;

import com.geofertas.dao.UserDAO;
import com.geofertas.entities.User;
import com.geofertas.service.UserService;

/**
 * Created by whoami on 12/13/15.
 */
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(User user) {
        userDAO.registerUser(user);
    }


}
