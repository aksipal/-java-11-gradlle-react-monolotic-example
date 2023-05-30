package com.axpal.model;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Temel transfer nesnesidir
 *
 * @author Aksipal
 */
public abstract class AxpalModel implements AxpalModelStructure<Long>,Comparable<AxpalModel>{

    private static final long serialVersionUID = -1L;

    private Long id;

    private String uuid;

    private Integer version;

    private OffsetDateTime dateCreated;

    private OffsetDateTime dateUpdated;

    private String createdBy;

    private String UpdatedBy;

    private Boolean deleted = Boolean.FALSE;

    private OffsetDateTime deletedDate;

    /**
     * {@inheritDoc}
     */

    @Override
    public Long getId() {
        return id;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getUuid() {
        return uuid;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(OffsetDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        return id != null && id.equals(((AxpalModel)o).id);
    }

    @Override
    public int compareTo(AxpalModel o) {
        return Integer.compare(this.hashCode(),o.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
