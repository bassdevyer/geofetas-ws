package com.geofertas.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
@Table(name = "user", schema = "public", catalog = "geofertas")
//@XmlRootElement(name = "User")
public class User {
    private Long id;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String authenticationType;
    private String picturePath;
    private byte[] picture;
    private String enabled;
    private List<UserCompany> userCompany;
    private List<UserParameter> userParameter;
    private List<UserTag> userTag;
    private List<UserAdvertisement> userAdvertisement;

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "authentication_type", nullable = false, length = 1)
    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    @Column(name = "enabled", nullable = false, length = 1)
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


    @Column(name = "picture", nullable = true, length = 250)
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Column(insertable=false, updatable=false)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<UserCompany> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<UserCompany> userCompany) {
        this.userCompany = userCompany;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<UserParameter> getUserParameter() {
        return userParameter;
    }

    public void setUserParameter(List<UserParameter> userParameter) {
        this.userParameter = userParameter;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<UserTag> getUserTag() {
        return userTag;
    }

    public void setUserTag(List<UserTag> userTag) {
        this.userTag = userTag;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<UserAdvertisement> getUserAdvertisement() {
        return userAdvertisement;
    }

    public void setUserAdvertisement(List<UserAdvertisement> userAdvertisement) {
        this.userAdvertisement = userAdvertisement;
    }
}
