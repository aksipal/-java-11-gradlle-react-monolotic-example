package com.axpal.repository;
import com.axpal.entity.AxpalSimpleEntity;
import com.querydsl.core.dml.DeleteClause;
import com.querydsl.core.dml.InsertClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAInsertClause;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import java.util.List;
import java.util.Optional;

/**
 * Temel veritabani nesnesi ile veritabani islemlerini saglayan arayuzdur.
 *
 * @param <HSE> Veritabani nesne sinifi
 */
@NoRepositoryBean
public interface AxpalJpaSimpleRepository<HSE extends AxpalSimpleEntity<ID>,ID extends Number>
        extends JpaRepository<HSE,ID>, AxpalJpaSearchRepository<HSE> {

    InsertClause<JPAInsertClause> getInsertClause(EntityPath<?> path);

    UpdateClause<JPAUpdateClause> getUpdateClause(EntityPath<?>path);

    DeleteClause<JPADeleteClause> getDeleteClause(EntityPath<?>path);

    JPQLQuery<Object> from (EntityPath<?>... paths);

    <T>JPQLQuery<T> from (EntityPath<T> path);

    @Override
    <S extends HSE> S saveAndFlush(S entity);

    HSE update (@NonNull HSE entity);

    void updateWithoutFind(@NonNull HSE entity);

    HSE updateAndFlush(@NonNull HSE entity);

    void updateAndFlushWithoutFind(@NonNull HSE entity);

    HSE geyById(@NonNull ID id);

    HSE getByIdWithDeleted(@NonNull ID id);

    @Modifying
    @Override
    Optional<HSE> findById(@NonNull ID id);

    Optional<HSE> findByIdWithDeleted(@NonNull ID id);

    @Modifying
    @Override
    List<HSE> findAllById(@NonNull Iterable<ID> ids);

    List<HSE> findAllByIdWithDeleted(@NonNull Iterable<ID> ids);

    @Modifying
    @Override
    boolean existsById(@NonNull ID id);

    boolean existsByIdWithDeleted(@NonNull ID id);

    HSE getByUuid(@NonNull String uuid);

    HSE getByUuidWithDeleted(@NonNull String uuid);

    Optional<HSE> findByUuid(@NonNull String uuid);

    Optional<HSE> findByUuidWithDeleted(@NonNull String uuid);

    List<HSE> findAllByUuid(@NonNull Iterable<String> uuids);

    List<HSE> findAllByUuidWithoutDeleted(@NonNull Iterable<String> uuids);

    boolean existsByUuid(@NonNull String uuid);

    boolean existsByUuidWithDeleted(@NonNull String uuid);
}
