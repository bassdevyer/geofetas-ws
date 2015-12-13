package com.geofertas.entities;

import javax.persistence.*;

/**
 * Created by whoami on 12/12/15.
 */
@Entity
@Table(name = "USER_TAG", schema = "public", catalog = "geofertas")
public class UserTag {
    private long id;
    private long userId;
    private long tagId;
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
    @Column(name = "tag_id")
    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
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

        UserTag userTag = (UserTag) o;

        if (id != userTag.id) return false;
        if (userId != userTag.userId) return false;
        if (tagId != userTag.tagId) return false;
        if (enabled != userTag.enabled) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (tagId ^ (tagId >>> 32));
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
