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

    // Customizes the mapping of the return value to a WSDL part and XML element.s
    @WebResult
    String sayHello(String name);

    User authenticate(String username, String hashPassword);
    List<Advertisement> getAdvertisements(Double lat, Double lon);
    Boolean saveAdvertisement(Integer advertisementID, Integer userId);
    List<Advertisement> getSavedAdvertisements(Integer userID);
    User updateUser(User user);
    User registerUser(User user);
    Boolean resetPasword(Integer userID);




}
