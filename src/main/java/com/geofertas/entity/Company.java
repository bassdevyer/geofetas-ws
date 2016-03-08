package com.geofertas.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
@Table(name = "company", schema = "public", catalog = "geofertas")
@XmlRootElement(name = "Company")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Company {
    private Long id;
    private String name;
    private String description;
    private String logo;
    private byte[] logoBytes;
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

    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "logo", nullable = true, length = -1)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "enabled", nullable = false, length = -1)
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Transient
    @Column(insertable=false, updatable=false)
    public byte[] getLogoBytes() {
        return logoBytes;
    }

    public void setLogoBytes(byte[] logoBytes) {
        this.logoBytes = logoBytes;
    }

    @OneToMany(mappedBy = "company")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    public List<BranchOffice> getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(List<BranchOffice> branchOffice) {
        this.branchOffice = branchOffice;
    }

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<UserCompany> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<UserCompany> userCompany) {
        this.userCompany = userCompany;
    }
}
