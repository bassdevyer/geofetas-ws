package com.geofertas.service;

import com.geofertas.entity.User;
import org.springframework.dao.DataAccessException;

import java.io.IOException;

/**
 * Created by whoami on 12/13/15.
 */
public interface UserService {
    User registerUser(User user) throws DataAccessException, IOException;

    User authenticate(String username, String password);

}
