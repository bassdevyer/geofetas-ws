package com.geofertas.entity;

import javax.persistence.*;

/**
 * Created by whoami on 12/20/15.
 */
@Entity
@Table(name = "user_tag", schema = "public", catalog = "geofertas")
public class UserTag {
    private Long id;
    private Long userId;
    private Long tagId;
    private String enabled;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tag_id")
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "enabled")
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

        UserTag userTag = (UserTag) o;

        if (id != null ? !id.equals(userTag.id) : userTag.id != null) return false;
        if (userId != null ? !userId.equals(userTag.userId) : userTag.userId != null) return false;
        if (tagId != null ? !tagId.equals(userTag.tagId) : userTag.tagId != null) return false;
        if (enabled != null ? !enabled.equals(userTag.enabled) : userTag.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
