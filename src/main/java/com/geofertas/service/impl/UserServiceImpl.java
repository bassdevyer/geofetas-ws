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
        user.setPicturePath(filePath);
        Object outcome = userDAO.registerUser(user);
        if(outcome != null){
            User outcomeUser = (User) outcome;
            File file = new File(outcomeUser.getPicturePath());
            outcomeUser.setPicture(FileUtils.readFileToByteArray(file));
            return user;
        }
        return null;
    }

    public User authenticate(String username, String password) {
        Object outcome = userDAO.authenticate(username, password);
        if(outcome != null){
            User user = (User) outcome;
            File file = new File(System.getProperty("geofertas.images.dir").toString().concat(File.separator).concat(user.getPicturePath()));
            try {
                user.setPicture(FileUtils.readFileToByteArray(file));
            }catch(IOException e){
                log.error(e);
            }
        }
        return (outcome != null) ? (User) outcome : null;
    }
}
