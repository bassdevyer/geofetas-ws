package com.geofertas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
public class User {
    private Long id;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String authenticationType;
    private String enabled;
    private List<Parameter> parameter;
    private List<UserCompany> userCompany;
    private List<UserParameter> userParameter;
    private List<UserTag> userTag;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "authentication_type", nullable = false, length = -1)
    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    @Basic
    @Column(name = "enabled", nullable = false, length = -1)
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (authenticationType != null ? !authenticationType.equals(user.authenticationType) : user.authenticationType != null)
            return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (authenticationType != null ? authenticationType.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user")
    public List<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    @OneToMany(mappedBy = "user")
    public List<UserCompany> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<UserCompany> userCompany) {
        this.userCompany = userCompany;
    }

    @OneToMany(mappedBy = "user")
    public List<UserParameter> getUserParameter() {
        return userParameter;
    }

    public void setUserParameter(List<UserParameter> userParameter) {
        this.userParameter = userParameter;
    }

    @OneToMany(mappedBy = "user")
    public List<UserTag> getUserTag() {
        return userTag;
    }

    public void setUserTag(List<UserTag> userTag) {
        this.userTag = userTag;
    }
}
