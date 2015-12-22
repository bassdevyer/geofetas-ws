package com.geofertas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
public class Tag {
    private Long id;
    private Long name;
    private String enabled;
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
    @Column(name = "name", nullable = false)
    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
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

        Tag tag = (Tag) o;

        if (id != null ? !id.equals(tag.id) : tag.id != null) return false;
        if (name != null ? !name.equals(tag.name) : tag.name != null) return false;
        if (enabled != null ? !enabled.equals(tag.enabled) : tag.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tag")
    public List<UserTag> getUserTag() {
        return userTag;
    }

    public void setUserTag(List<UserTag> userTag) {
        this.userTag = userTag;
    }
}
