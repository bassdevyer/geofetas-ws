package com.geofertas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
public class Parameter {
    private Long id;
    private String name;
    private String value;
    private String enabled;
    private List<UserParameter> userParameter;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 255)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

        Parameter parameter = (Parameter) o;

        if (id != null ? !id.equals(parameter.id) : parameter.id != null) return false;
        if (name != null ? !name.equals(parameter.name) : parameter.name != null) return false;
        if (value != null ? !value.equals(parameter.value) : parameter.value != null) return false;
        if (enabled != null ? !enabled.equals(parameter.enabled) : parameter.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "parameter")
    public List<UserParameter> getUserParameter() {
        return userParameter;
    }

    public void setUserParameter(List<UserParameter> userParameter) {
        this.userParameter = userParameter;
    }
}
