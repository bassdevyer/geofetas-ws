package com.geofertas.dao.impl;

import com.geofertas.dao.AdvertisementDAO;
import com.geofertas.entity.Advertisement;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by whoami on 12/19/15.
 */
public class AdvertisementDAOImpl implements AdvertisementDAO {



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //SELECT * FROM Places WHERE acos(sin(1.3963) * sin(Lat) + cos(1.3963) * cos(Lat) * cos(Lon - (-0.6981))) * 6371 <= 1000;
    public List<Advertisement> getAdvertisements(Double lat, Double lon) {
        Session session = sessionFactory.getCurrentSession();
        //Query query = session.createQuery("from Advertisement join AdvertisementBranch where acos(sin(:lat) * sin(Lat) + cos(:lat) * cos(Lat) * cos(Lon - (:lon))) * 6371000 <= 500")
        //query.setParameter("lat", lat);
        //query.setParameter("lon", lon);
        Query query = session.createQuery("from Advertisement ");
        return query.list();
    }
}
