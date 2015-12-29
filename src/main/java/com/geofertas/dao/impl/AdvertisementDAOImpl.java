package com.geofertas.dao.impl;

import com.geofertas.dao.AdvertisementDAO;
import com.geofertas.entity.Advertisement;
import org.hibernate.Criteria;
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
    public List<Advertisement> getAdvertisements(Double lat, Double lon, Double radius) {
        Session session = sessionFactory.getCurrentSession();
        //(Criteria criteria = session.createCriteria(Advertisement.class);
        //criteria.createAlias("advertisementBranch", "adb").createAlias("adb.branchOffice", "bo");


        //Query query = session.createQuery("select adv from Advertisement  adv join adv.advertisementBranch adb join adb.branchOffice bro");
        //Query query = session.createQuery("from Advertisement  adv");
        Query query = session.createQuery("select adv from Advertisement adv join adv.advertisementBranch adb join adb.branchOffice bo " +
                        "where acos(sin(:lat) * sin(bo.latitude) + cos(:lat) * cos(bo.latitude) * cos(bo.longitude - (:lon))) * 6371000 <= :radius");
        query.setParameter("lat", lat);
         query.setParameter("lon", lon);
        query.setParameter("radius", radius);
        //return criteria.list();
        return query.list();
    }
}
