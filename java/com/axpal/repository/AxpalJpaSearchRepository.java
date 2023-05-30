package com.axpal.repository;
import com.axpal.criteria.AxpalPage;
import com.axpal.criteria.AxpalPageable;
import com.axpal.criteria.AxpalSort;
import com.axpal.data.query.AxpalProjectionsQueryExpression;
import com.axpal.data.query.AxpalQueryExpression;
import com.axpal.data.query.AxpalTupleQueryExpression;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.MappingProjection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.lang.NonNull;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * Temel veritabani nesnesi ile veritabani islemlerini saglayan arayuzdur.
 *
 * @param <SE> Veritabani nesne sinifi
 */
public interface AxpalJpaSearchRepository<SE> extends QuerydslPredicateExecutor<SE> {

    EntityManager getEntityManager();

    JPAQuery<SE> getJpaQuery();

    Optional<SE> get(@NonNull Predicate predicate);

    @Modifying
    @Override
    Optional<SE> findOne(@NonNull Predicate predicate);

    <PQE> PQE findOne(@NonNull AxpalProjectionsQueryExpression<PQE> projectionsQueryExpression);

    @Modifying
    @Override
    boolean exists(@NonNull Predicate predicate);

    @Modifying
    List<SE> findAll();

    @Modifying
    @Override
    List<SE> findAll(@NonNull Predicate predicate);

    @Modifying
    @Override
    List<SE> findAll(@NonNull Predicate predicate, @NonNull Sort sort);

    @Modifying
    @Override
    List<SE> findAll(@NonNull Predicate predicate, @NonNull OrderSpecifier<?>...orders);

    @Modifying
    @Override
    List<SE> findAll(@NonNull OrderSpecifier<?>...orders);

    List<SE> findAll(@NonNull AxpalSort sort);

    List<SE> findAll(@NonNull Predicate predicate,@NonNull AxpalSort sort);

    AxpalPage<SE> findAll(@NonNull AxpalPageable pageable);

    AxpalPage<SE> findAll(@NonNull Predicate predicate, @NonNull AxpalPageable pageable);

    <T>List<T> findAll(@NonNull MappingProjection<T>mappingProjection,@NonNull Predicate whereClause);

    List<SE> findAll(AxpalQueryExpression queryExpression);

    AxpalPage<SE> findAll(AxpalQueryExpression queryExpression, @NonNull AxpalPageable pageable);

    List<Tuple> findAll(AxpalTupleQueryExpression tupleQueryExpression);

    AxpalPage<Tuple> findAll(AxpalTupleQueryExpression tupleQueryExpression,@NonNull AxpalPageable pageable);

    <PQE>List<PQE> findAll(AxpalProjectionsQueryExpression<PQE>projectionsQueryExpression);

    <PQE>AxpalPage<PQE> findAll(AxpalProjectionsQueryExpression<PQE>projectionsQueryExpression,@NonNull AxpalPageable pageable);

    <SE>AxpalPage<SE> findAll(JPAQuery<SE>jpaQuery,@NonNull AxpalPageable pageable);

    @Modifying
    @Override
    long count(@NonNull Predicate predicate);

    List<Object> query(@NonNull String jpql);
}
