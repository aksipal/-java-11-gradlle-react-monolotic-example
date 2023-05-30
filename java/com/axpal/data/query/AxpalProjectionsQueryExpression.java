package com.axpal.data.query;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;

import java.util.List;


/**
 * {@link com.querydsl.core.types.Projections} yapilacak olan sorgularda kullanilmasi gereken siniftir.
 */
public class AxpalProjectionsQueryExpression<PQE> extends AxpalTupleQueryExpression {

    private Class<PQE> mappingClass;

    public AxpalProjectionsQueryExpression(Class<PQE> mappingClass,
                                          List<Expression<?>> selectExpressionList,
                                          Predicate whereClause) {
        super(whereClause, selectExpressionList);
        this.mappingClass = mappingClass;
    }

    public AxpalProjectionsQueryExpression(Class<PQE> mappingClass,
                                          List<Expression<?>> selectExpressionList,
                                          Predicate whereClause,
                                          List<AxpalJoinExpression> joinExpressionList) {
        super(whereClause, joinExpressionList,selectExpressionList);
        this.mappingClass = mappingClass;
    }

    public AxpalProjectionsQueryExpression(Class<PQE> mappingClass,
                                          List<Expression<?>> selectExpressionList,
                                          Predicate whereClause,
                                          List<AxpalJoinExpression> joinExpressionList,
                                          boolean distinct) {
        super(whereClause, joinExpressionList, selectExpressionList, distinct);
        this.mappingClass = mappingClass;
    }

    public Class<PQE> getMappingClass() {
        return mappingClass;
    }

    public void setMappingClass(Class<PQE> mappingClass) {
        this.mappingClass = mappingClass;
    }
}
