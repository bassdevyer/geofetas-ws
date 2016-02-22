package com.geofertas.service;

import com.geofertas.entity.BranchOffice;

import java.util.List;

/**
 * Created by mac on 21/2/16.
 */
public interface BranchOfficeService {

    List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius);

}
