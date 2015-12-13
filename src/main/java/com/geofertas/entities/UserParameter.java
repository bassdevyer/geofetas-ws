package com.geofertas.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by whoami on 12/12/15.
 */
@Entity
@Table(name = "USER_PARAMETER", schema = "public", catalog = "geofertas")
public class UserParameter {
    private long id;
    private long userId;
    private long parameterId;
    private boolean enabled;

    @Basic
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
    @Column(name = "parameter_id")
    public long getParameterId() {
        return parameterId;
    }

    public void setParameterId(long parameterId) {
        this.parameterId = parameterId;
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

        UserParameter that = (UserParameter) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (parameterId != that.parameterId) return false;
        if (enabled != that.enabled) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (parameterId ^ (parameterId >>> 32));
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
