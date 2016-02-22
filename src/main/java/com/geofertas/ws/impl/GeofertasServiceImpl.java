package com.geofertas.ws.impl;

import com.geofertas.entity.Advertisement;
import com.geofertas.entity.BranchOffice;
import com.geofertas.entity.User;
import com.geofertas.service.AdvertisementService;
import com.geofertas.service.BranchOfficeService;
import com.geofertas.service.UserService;
import com.geofertas.ws.GeofertasService;
import org.springframework.dao.DataAccessException;

import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

/**
 * Created by whoami on 12/12/15.
 */
@WebService(endpointInterface = "com.geofertas.ws.GeofertasService")
public class GeofertasServiceImpl implements GeofertasService {

    private UserService userService;
    private AdvertisementService advertisementService;
    private BranchOfficeService branchOfficeService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public void setBranchOfficeService(BranchOfficeService branchOfficeService){
        this.branchOfficeService = branchOfficeService;
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
        return userService.updateUser(user);
    }

    public User registerUser(User user) {

        try {
            return userService.registerUser(user);
        }catch(DataAccessException | IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean resetPasword(Integer userID) {
        return null;
    }

    @Override
    public List<BranchOffice> getBranchOffices(Double lat, Double lon, Double radius) {
        return branchOfficeService.getBranchOffices(lat, lon, radius);
    }
}
