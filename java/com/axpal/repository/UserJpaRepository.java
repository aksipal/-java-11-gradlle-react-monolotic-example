package com.axpal.repository;

import com.axpal.entity.AxpalEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserJpaRepository <HE extends AxpalEntity> extends AxpalJpaSimpleRepository<HE,Long>{
}
