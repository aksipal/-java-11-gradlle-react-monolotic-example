package com.axpal.repository;


import com.axpal.entity.AxpalEntity;
import com.axpal.entity.AxpalUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserJpaRepository<AxpalUserEntity> {

}