package com.geofertas.dao;

import com.geofertas.entities.User;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 12/13/15.
 */
public interface UserDAO {

    @Transactional
    void registerUser(User user) throws DataAccessException;
}
