package com.axpal.entity;

import com.axpal.constans.UserContstans;
import lombok.Data;

import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Table(schema = UserContstans.USER_SHEMA_NAME, name = UserContstans.TABLE_NAME,
        indexes = {@Index(columnList = "USER_ID", name = "IDX_USER")
        })
public class AxpalBaseEntity {
    private Long Id ;
}
