package com.geofertas.entity;

import javax.persistence.*;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
@Table(name = "user_tag", schema = "public", catalog = "geofertas")
public class UserTag {
    private Long id;
    private String enabled;
    private Tag tag;
    private User user;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        UserTag userTag = (UserTag) o;

        if (id != null ? !id.equals(userTag.id) : userTag.id != null) return false;
        if (enabled != null ? !enabled.equals(userTag.enabled) : userTag.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "tag_id")
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
