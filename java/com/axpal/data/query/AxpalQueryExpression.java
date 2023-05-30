package com.axpal.data.query;

import com.querydsl.core.types.Predicate;

import java.io.Serializable;
import java.util.List;


/**
 * {@link com.querydsl.core.Tuple} turunden nesne dınecek olan sorgularda kullanilmasi gereken siniftir.
 */
public class AxpalQueryExpression implements Serializable {

    private Predicate whereClause;

    private List<AxpalJoinExpression> joinExpressionList;

    private boolean distinct;

    public AxpalQueryExpression() {
    }

    public AxpalQueryExpression(Predicate whereClause) {
        this.whereClause = whereClause;
    }

    public AxpalQueryExpression(Predicate whereClause, List<AxpalJoinExpression> joinExpressionList) {
        this.whereClause = whereClause;
        this.joinExpressionList = joinExpressionList;
    }

    public AxpalQueryExpression(Predicate whereClause, List<AxpalJoinExpression> joinExpressionList, boolean distinct) {
        this.whereClause = whereClause;
        this.joinExpressionList = joinExpressionList;
        this.distinct = distinct;
    }

    public Predicate getWhereClause() {
        return whereClause;
    }

    public List<AxpalJoinExpression> getJoinExpressionList() {
        return joinExpressionList;
    }

    public boolean isDistinct() {
        return distinct;
    }
}
