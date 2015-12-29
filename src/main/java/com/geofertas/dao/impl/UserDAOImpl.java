package com.geofertas.dao.impl;

import com.geofertas.dao.UserDAO;
import com.geofertas.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

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

    public Object authenticate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = :username and password = :password and authenticationType = 'N' and enabled = 'A'");
        query.setMaxResults(1);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.uniqueResult();
    }
}
