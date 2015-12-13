package com.geofertas.entities;

import javax.persistence.*;

/**
 * Created by whoami on 12/12/15.
 */
@Entity
@Table(name = "USER_ADVERTISEMENT", schema = "public", catalog = "geofertas")
public class UserAdvertisement {
    private long id;
    private long userId;
    private long advertisementId;
    private boolean enabled;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "advertisement_id")
    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Basic
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAdvertisement that = (UserAdvertisement) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (advertisementId != that.advertisementId) return false;
        if (enabled != that.enabled) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (advertisementId ^ (advertisementId >>> 32));
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
