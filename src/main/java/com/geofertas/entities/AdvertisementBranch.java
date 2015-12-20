package com.geofertas.entities;

import javax.persistence.*;

/**
 * Created by whoami on 12/20/15.
 */
@Entity
@Table(name = "ADVERTISEMENT_BRANCH", schema = "public", catalog = "geofertas")
public class AdvertisementBranch {
    private long idAdvertisement;
    private long idBranchOffice;
    private long id;

    @Basic
    @Column(name = "id_advertisement")
    public long getIdAdvertisement() {
        return idAdvertisement;
    }

    public void setIdAdvertisement(long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    @Basic
    @Column(name = "id_branch_office")
    public long getIdBranchOffice() {
        return idBranchOffice;
    }

    public void setIdBranchOffice(long idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementBranch that = (AdvertisementBranch) o;

        if (idAdvertisement != that.idAdvertisement) return false;
        if (idBranchOffice != that.idBranchOffice) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAdvertisement ^ (idAdvertisement >>> 32));
        result = 31 * result + (int) (idBranchOffice ^ (idBranchOffice >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
