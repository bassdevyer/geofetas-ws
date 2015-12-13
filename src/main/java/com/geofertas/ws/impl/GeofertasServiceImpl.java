package com.geofertas.ws.impl;

import com.geofertas.entities.Advertisement;
import com.geofertas.entities.User;
import com.geofertas.ws.GeofertasService;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by whoami on 12/12/15.
 */
@WebService(endpointInterface = "com.geofertas.ws.GeofertasService")
public class GeofertasServiceImpl implements GeofertasService {


    public String sayHello(String name) {
        return null;
    }

    public User authenticate(String username, String hashPassword) {
        return null;
    }

    public List<Advertisement> getAdvertisements(Double lat, Double lon) {
        return null;
    }

    public Boolean saveAdvertisement(Integer advertisementID, Integer userId) {
        return null;
    }

    public List<Advertisement> getSavedAdvertisements(Integer userID) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public User registerUser(User user) {
        return null;
    }

    public Boolean resetPasword(Integer userID) {
        return null;
    }
}
