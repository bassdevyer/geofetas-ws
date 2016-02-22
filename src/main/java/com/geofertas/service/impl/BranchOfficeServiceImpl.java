package com.geofertas.service.impl;

import com.geofertas.dao.BranchOfficeDao;
import com.geofertas.entity.BranchOffice;
import com.geofertas.service.BranchOfficeService;

import java.util.List;

/**
 * Created by mac on 21/2/16.
 */
public class BranchOfficeServiceImpl implements BranchOfficeService{

    private BranchOfficeDao branchOfficeDao;

    public void setBranchOfficeDao(BranchOfficeDao branchOfficeDao){
        this.branchOfficeDao = branchOfficeDao;
    }

    @Override
    public List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius) {
        return branchOfficeDao.getBranchOffices(lat, lon, radius);
    }
}
