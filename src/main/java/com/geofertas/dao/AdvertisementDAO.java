package com.geofertas.dao;

import com.geofertas.entities.Advertisement;

import java.util.List;

/**
 * Created by whoami on 12/19/15.
 */
public interface AdvertisementDAO {

    List<Advertisement> getAdvertisements(Double lat, Double lon);
}
