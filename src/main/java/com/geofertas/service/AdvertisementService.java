package com.geofertas.service;

import com.geofertas.entity.Advertisement;

import java.util.List;

/**
 * Created by whoami on 12/19/15.
 */
public interface AdvertisementService {

    List<Advertisement> getAdvertisements(Double lat, Double lon);
}
