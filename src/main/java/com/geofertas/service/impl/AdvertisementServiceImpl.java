package com.geofertas.service.impl;

import com.geofertas.dao.AdvertisementDAO;
import com.geofertas.entity.Advertisement;
import com.geofertas.service.AdvertisementService;

import java.util.List;

/**
 * Created by whoami on 12/19/15.
 */
public class AdvertisementServiceImpl implements AdvertisementService{

    private AdvertisementDAO advertisementDAO;

    public void setAdvertisementDAO(AdvertisementDAO advertisementDAO) {
        this.advertisementDAO = advertisementDAO;
    }

    public List<Advertisement> getAdvertisements(Double lat, Double lon) {
        // TODO aplicar reglas de negocio para busqueda de ofertas
        return advertisementDAO.getAdvertisements(lat, lon);
    }
}
