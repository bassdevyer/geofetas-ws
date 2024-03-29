package com.geofertas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whoami on 12/21/15.
 */
@Entity
public class Catalogue {
    private Long id;
    private String name;
    private String description;
    private String enabled;
    private List<CatalogueDetail> catalogueDetail;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        Catalogue catalogue = (Catalogue) o;

        if (id != null ? !id.equals(catalogue.id) : catalogue.id != null) return false;
        if (name != null ? !name.equals(catalogue.name) : catalogue.name != null) return false;
        if (description != null ? !description.equals(catalogue.description) : catalogue.description != null)
            return false;
        if (enabled != null ? !enabled.equals(catalogue.enabled) : catalogue.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "catalogue")
    public List<CatalogueDetail> getCatalogueDetail() {
        return catalogueDetail;
    }

    public void setCatalogueDetail(List<CatalogueDetail> catalogueDetail) {
        this.catalogueDetail = catalogueDetail;
    }
}
