package com.axpal.entity;
import com.axpal.entity.constraint.AxpalEntityConstraints;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.NotAudited;;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

/**
 * Fiziksel olarak silinmeyen temel veritabanı nesnesidir.
 *
 */
@MappedSuperclass
@AuditOverride(forClass = AxpalEntity.class)
public class AxpalSoftDeleteEntity extends AxpalEntity{

    public static final String DELETED_FIELD="deleted";

    public static final String DELETED_DATE_FIELD="deletedDate";

    public static final String DELETED_FIELD_COLUMN="DELETED";

    public static final String DELETED_DATE_FIELD_COLUMN="DELETED_AT";

    @Column(name = DELETED_FIELD_COLUMN)
    private Boolean deleted;

    @Column(name = DELETED_DATE_FIELD_COLUMN,columnDefinition = AxpalEntityConstraints.TIMESTAP_WITHOUT_UTC_DEFINATION)
    @NotAudited
    private OffsetDateTime deletedDate;

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
    public String getUuid() {
        return null;
    }

    @Override
    public void setUuid(String uuid) {

    }
}
