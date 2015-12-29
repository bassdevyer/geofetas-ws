package com.geofertas.service;

import com.geofertas.entity.User;
import org.springframework.dao.DataAccessException;

/**
 * Created by whoami on 12/13/15.
 */
public interface UserService {
    void registerUser(User user) throws DataAccessException;

    User authenticate(String username, String password);

}
