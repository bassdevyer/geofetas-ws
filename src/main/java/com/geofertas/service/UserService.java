package com.geofertas.service;

import com.geofertas.entities.User;
import org.springframework.dao.DataAccessException;

/**
 * Created by whoami on 12/13/15.
 */
public interface UserService {

    void registerUser(User user) throws DataAccessException;

}
