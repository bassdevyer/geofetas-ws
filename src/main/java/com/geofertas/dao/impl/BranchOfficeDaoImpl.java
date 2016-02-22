package com.geofertas.dao.impl;

import com.geofertas.dao.BranchOfficeDao;
import com.geofertas.entity.BranchOffice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by mac on 21/2/16.
 */
public class BranchOfficeDaoImpl implements BranchOfficeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BranchOffice");
        return query.list();
    }
}
