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

    public Object registerUser(User user) throws DataAccessException {
        Session session = sessionFactory.getCurrentSession();
        Long newId = (Long) session.save(user);
        if(newId != 0L){
            return session.get(User.class, newId);
        }
        return null;
    }

    public Object authenticate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = :username and password = :password and authenticationType = 'N' and enabled = 'A'");
        query.setMaxResults(1);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.uniqueResult();
    }

    @Override
    public Object updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        return session.merge(user);
    }

    @Override
    public Object getUserByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = :username and enabled = 'A'");
        query.setMaxResults(1);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

}
