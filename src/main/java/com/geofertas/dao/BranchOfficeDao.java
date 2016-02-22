package com.geofertas.dao;

import com.geofertas.entity.BranchOffice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mac on 21/2/16.
 */
public interface BranchOfficeDao {

    @Transactional
    List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius);

}
