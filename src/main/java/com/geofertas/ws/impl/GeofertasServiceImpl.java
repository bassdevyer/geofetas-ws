package com.geofertas.ws.impl;

import com.geofertas.entity.Advertisement;
import com.geofertas.entity.User;
import com.geofertas.service.AdvertisementService;
import com.geofertas.service.UserService;
import com.geofertas.ws.GeofertasService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.dao.DataAccessException;

import javax.jws.WebService;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by whoami on 12/12/15.
 */
@WebService(endpointInterface = "com.geofertas.ws.GeofertasService")
public class GeofertasServiceImpl implements GeofertasService {

    private UserService userService;
    private AdvertisementService advertisementService;


    public String test(){
        return "testing ws";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public User authenticate(String username, String hashPassword) {
        return userService.authenticate(username, hashPassword);
    }

    public List<Advertisement> getAdvertisements(Double lat, Double lon, Double radius) {
        return advertisementService.getAdvertisements(lat, lon, radius);
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

    public User registerUser(String username, String lastname, String firstname, String email, String password, String authenticationType) {
        User user = new User();
        user.setUsername(username);
        user.setLastName(lastname);
        user.setFirstName(firstname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAuthenticationType(authenticationType);
        try {
            userService.registerUser(user);
            return user;
        }catch(DataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean resetPasword(Integer userID) {
        return null;
    }
}
