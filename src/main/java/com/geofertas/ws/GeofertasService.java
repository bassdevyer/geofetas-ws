package com.geofertas.ws;

import com.geofertas.entities.Advertisement;
import com.geofertas.entities.User;

import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by whoami on 11/22/15.
 * Defines the web service interface
 */
@WebService
public interface GeofertasService {

    User authenticate(String username, String hashPassword);
    List<Advertisement> getAdvertisements(Double lat, Double lon);
    Boolean saveAdvertisement(Integer advertisementID, Integer userId);
    List<Advertisement> getSavedAdvertisements(Integer userID);
    User updateUser(User user);
    User registerUser(String username, String lastname, String firstname, String email, String password, String authenticationType);
    Boolean resetPasword(Integer userID);




}
