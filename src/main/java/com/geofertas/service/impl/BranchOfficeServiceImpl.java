package com.geofertas.service.impl;

import com.geofertas.dao.BranchOfficeDao;
import com.geofertas.entity.*;
import com.geofertas.service.BranchOfficeService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by mac on 21/2/16.
 */
public class BranchOfficeServiceImpl implements BranchOfficeService{

    private BranchOfficeDao branchOfficeDao;

    Log log = LogFactory.getLog(BranchOfficeServiceImpl.class);

    public void setBranchOfficeDao(BranchOfficeDao branchOfficeDao){
        this.branchOfficeDao = branchOfficeDao;
    }

    @Override
    public List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius) {
        List<BranchOffice> outcome = branchOfficeDao.getBranchOffices(lat, lon, radius);

        if(outcome != null && !outcome.isEmpty()){
            for(BranchOffice branchOffice : outcome){
                try {
                    if(System.getProperty("geofertas.images.dir") == null){
                        log.warn("Geofertas Images Directory not defined");
                    }
                    else{
                        File file = new File(System.getProperty("geofertas.images.dir").toString().concat(File.separator).concat(branchOffice.getCompany().getLogo()));
                        branchOffice.getCompany().setLogoBytes(FileUtils.readFileToByteArray(file));

                        for(AdvertisementBranch advertisementBranch : branchOffice.getAdvertisementBranch()){
                            File file1 = new File(System.getProperty("geofertas.images.dir").toString().concat(File.separator).concat(advertisementBranch.getAdvertisement().getImage()));
                            advertisementBranch.getAdvertisement().setImageBytes(FileUtils.readFileToByteArray(file1));
                        }
                    }
                }catch(IOException e){
                    log.error(e);
                }
            }
        }
        return outcome;
    }
}
