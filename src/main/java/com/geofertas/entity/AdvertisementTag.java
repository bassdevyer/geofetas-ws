package com.geofertas.entity;

import javax.persistence.*;

/**
 * Created by whoami on 12/20/15.
 */
@Entity
@Table(name = "advertisement_tag", schema = "public", catalog = "geofertas")
public class AdvertisementTag {
    private Long id;
    private Long advertisementId;
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
    @Column(name = "advertisement_id")
    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
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

        AdvertisementTag that = (AdvertisementTag) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advertisementId != null ? !advertisementId.equals(that.advertisementId) : that.advertisementId != null)
            return false;
        if (tagId != null ? !tagId.equals(that.tagId) : that.tagId != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
