package com.geofertas.entity;

import javax.persistence.*;

/**
 * Created by whoami on 12/20/15.
 */
@Entity
@Table(name = "advertisement_branch", schema = "public", catalog = "geofertas")
public class AdvertisementBranch {
    private Long idAdvertisement;
    private Long idBranchOffice;
    private Long id;
    private String enabled;

    @Basic
    @Column(name = "id_advertisement")
    public Long getIdAdvertisement() {
        return idAdvertisement;
    }

    public void setIdAdvertisement(Long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    @Basic
    @Column(name = "id_branch_office")
    public Long getIdBranchOffice() {
        return idBranchOffice;
    }

    public void setIdBranchOffice(Long idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        AdvertisementBranch that = (AdvertisementBranch) o;

        if (idAdvertisement != null ? !idAdvertisement.equals(that.idAdvertisement) : that.idAdvertisement != null)
            return false;
        if (idBranchOffice != null ? !idBranchOffice.equals(that.idBranchOffice) : that.idBranchOffice != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdvertisement != null ? idAdvertisement.hashCode() : 0;
        result = 31 * result + (idBranchOffice != null ? idBranchOffice.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
