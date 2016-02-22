package com.geofertas.service.impl;

import com.geofertas.dao.UserDAO;
import com.geofertas.entity.User;
import com.geofertas.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by whoami on 12/13/15.
 */
public class UserServiceImpl implements UserService {

    Log log = LogFactory.getLog(UserServiceImpl.class);

    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User registerUser(User user) throws IOException {
        UUID filename = UUID.randomUUID();
        String filePath = System.getProperty("geofertas.images.dir").toString().concat(filename.toString());
        File newFile = new File(filePath);
        FileUtils.writeByteArrayToFile(newFile, user.getPicture());
        user.setPicturePath(filename.toString());
        Object outcome = userDAO.registerUser(user);
        if(outcome != null){
            User outcomeUser = (User) outcome;
            File file = new File(filePath);
            outcomeUser.setPicture(FileUtils.readFileToByteArray(file));
            return user;
        }
        return null;
    }

    public User authenticate(String username, String password) {
        Object outcome = userDAO.authenticate(username, password);
        if(outcome != null){
            try {
                User user = (User) outcome;
                if(System.getProperty("geofertas.images.dir") == null){
                    log.warn("Geofertas Images Directory not defined");
                }
                else{
                    File file = new File(System.getProperty("geofertas.images.dir").toString().concat(File.separator).concat(user.getPicturePath()));
                    user.setPicture(FileUtils.readFileToByteArray(file));
                }
            }catch(IOException e){
                log.error(e);
            }
        }
        return (outcome != null) ? (User) outcome : null;
    }

    @Override
    public User updateUser(User user) {
        Object toUpdate = userDAO.getUserByUsername(user.getUsername());
        if(toUpdate != null){
            User userToUpdate = (User) toUpdate;
            if(!userToUpdate.getPassword().equals(user.getPassword()))
                userToUpdate.setPassword(user.getPassword());
            if(!userToUpdate.getLastName().equals(user.getLastName()))
                userToUpdate.setLastName(user.getLastName());
            if(!userToUpdate.getPicture().equals(user.getPicture()))
                userToUpdate.setPicture(user.getPicture());
            if(!userToUpdate.getFirstName().equals(user.getFirstName()))
                userToUpdate.setFirstName(user.getFirstName());
            if(!userToUpdate.getEmail().equals(user.getEmail()))
                userToUpdate.setEmail(user.getEmail());
            Object outcome = userDAO.updateUser(userToUpdate);
            if(outcome != null){
                return (User) outcome;
            }
        }
        return null;
    }
}
