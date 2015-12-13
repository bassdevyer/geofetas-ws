package com.geofertas.dao.impl;

import com.geofertas.dao.UserDAO;
import com.geofertas.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;

/**
 * Created by whoami on 12/13/15.
 */
public class UserDAOImpl  implements UserDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void registerUser(User user) throws DataAccessException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }


}
