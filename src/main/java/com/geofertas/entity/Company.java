package com.geofertas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
public class Company {
    private Long id;
    private String name;
    private String description;
    private String logo;
    private String enabled;
    private List<BranchOffice> branchOffice;
    private List<UserCompany> userCompany;

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
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = -1)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

        Company company = (Company) o;

        if (id != null ? !id.equals(company.id) : company.id != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;
        if (logo != null ? !logo.equals(company.logo) : company.logo != null) return false;
        if (enabled != null ? !enabled.equals(company.enabled) : company.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "company")
    public List<BranchOffice> getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(List<BranchOffice> branchOffice) {
        this.branchOffice = branchOffice;
    }

    @OneToMany(mappedBy = "company")
    public List<UserCompany> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<UserCompany> userCompany) {
        this.userCompany = userCompany;
    }
}
