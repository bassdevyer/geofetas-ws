package com.geofertas.entity;

import javax.persistence.*;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
@Table(name = "advertisement_branch", schema = "public", catalog = "geofertas")
public class AdvertisementBranch {
    private Long id;
    private String enabled;
    private Advertisement advertisement;
    private BranchOffice branchOffice;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "enabled", nullable = true, length = -1)
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @ManyToOne
    @JoinColumn(name = "id_advertisement")
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @ManyToOne
    @JoinColumn(name = "id_branch_office")
    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
    }
}
