package com.geofertas.ws;

import com.geofertas.entity.Advertisement;
import com.geofertas.entity.User;
import org.codehaus.jackson.map.ObjectMapper;

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

    @GET
    @Path("/authenticate/{username}-{password}")
    @Produces("application/json")
    User authenticate(@PathParam("username") String username, @PathParam("password") String hashPassword);

    @GET
    @Path("/getAdvertisements/{lat}-{lon}-{rad}")
    @Produces("application/json")
    List<Advertisement> getAdvertisements(@PathParam("lat") Double lat, @PathParam("lon") Double lon, @PathParam("rad") Double radius);

    Boolean saveAdvertisement(Integer advertisementID, Integer userId);

    List<Advertisement> getSavedAdvertisements(Integer userID);
    User updateUser(User user);

    @POST
    @Path("/registerUser/{username}-{lastname}-{firstname}-{email}-{password}-{authenticationType}")
    @Produces("application/json")
    User registerUser(String username, String lastname, String firstname, String email, String password, String authenticationType);

    Boolean resetPasword(Integer userID);




}
