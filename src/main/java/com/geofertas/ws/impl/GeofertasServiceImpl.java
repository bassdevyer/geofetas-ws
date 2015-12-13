package com.geofertas.ws.impl;

import com.geofertas.entities.Advertisement;
import com.geofertas.entities.User;
import com.geofertas.service.UserService;
import com.geofertas.ws.GeofertasService;
import org.springframework.dao.DataAccessException;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by whoami on 12/12/15.
 */
@WebService(endpointInterface = "com.geofertas.ws.GeofertasService")
public class GeofertasServiceImpl implements GeofertasService {


    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
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
            return null;
        }
    }

    public Boolean resetPasword(Integer userID) {
        return null;
    }
}
