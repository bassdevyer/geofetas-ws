package com.geofertas.dao;

import com.geofertas.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 12/13/15.
 */
public interface UserDAO {

    @Transactional
    Object registerUser(User user) throws DataAccessException;

    @Transactional
    Object authenticate(String username, String password);

    @Transactional
    Object updateUser(User user);

    @Transactional
    Object getUserByUsername(String username);
}
