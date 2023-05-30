package com.axpal.entity;

import com.axpal.entity.constraint.AxpalEntityConstraints;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.NotAudited;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;

/**
 * Temel Veritabanı nesnesidir
 *
 * @author baksipal
 */

@MappedSuperclass
@AuditOverride(forClass = AxpalSimpleEntity.class)
public abstract class AxpalEntity extends AxpalSimpleEntity<Long> implements Comparable<AxpalEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = AxpalEntityConstraints.SEQUENCE_GENERATOR)
    @GenericGenerator(
            name = AxpalEntityConstraints.SEQUENCE_GENERATOR,
            strategy = AxpalEntityConstraints.SEQUENCE_GENERATOR_STRATEGY,
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = SequenceStyleGenerator.INITIAL_PARAM, value = AxpalEntityConstraints.SEQUENCE_GENERATOR_STRATEGY_INITIAL_PARAM),
                    @org.hibernate.annotations.Parameter(
                            name = SequenceStyleGenerator.INCREMENT_PARAM, value = AxpalEntityConstraints.SEQUENCE_GENERATOR_STRATEGY_INCREMENT_PARAM),
                    @org.hibernate.annotations.Parameter(
                            name = SequenceStyleGenerator.OPT_PARAM, value = AxpalEntityConstraints.SEQUENCE_GENERATOR_STRATEGY_POOL_PARAM),
            }
    )

    @Column(name = ID_FIELD_COLUMN, updatable = false)
    @NotAudited
    private Long id;

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
    public int compareTo(AxpalEntity entity) {
        return Integer.compare(this.hashCode(), entity.hashCode());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass() && (obj instanceof AxpalEntity && (id != null) ? id.equals(((AxpalEntity) obj).id) : (obj == this));
    }
}
