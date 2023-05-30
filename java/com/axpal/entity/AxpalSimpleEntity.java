package com.axpal.entity;

import com.axpal.strategy.AxpalEntityStructure;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = {AxpalEntityListener.class, AuditingEntityListener.class})
public abstract class AxpalSimpleEntity<ID extends Number> implements AxpalEntityStructure<ID> {

    public static final String ID_FIELD_COLUMN = "ID";
}
