package com.geofertas.dao;

import com.geofertas.entity.Advertisement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 12/19/15.
 */
public interface AdvertisementDAO {

    @Transactional
    List<Advertisement> getAdvertisements(Double lat, Double lon, Double radius);
}
