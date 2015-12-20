package com.geofertas.ws;

import com.geofertas.entity.Advertisement;
import com.geofertas.entity.User;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by whoami on 11/22/15.
 * Defines the web service interface
 */
@Path("/")
@WebService(name = "geofertasService")
public interface GeofertasService {

    @GET
    @Path("/test")
    @Consumes("application/json")
    String test();

    User authenticate(String username, String hashPassword);

    @GET
    @Path("/getAdvertisements/{lat}-{lon}")
    @Produces("application/json")
    List<Advertisement> getAdvertisements(@PathParam("lat") Double lat, @PathParam("lon") Double lon);
    Boolean saveAdvertisement(Integer advertisementID, Integer userId);

    List<Advertisement> getSavedAdvertisements(Integer userID);
    User updateUser(User user);

    User registerUser(String username, String lastname, String firstname, String email, String password, String authenticationType);
    Boolean resetPasword(Integer userID);




}
