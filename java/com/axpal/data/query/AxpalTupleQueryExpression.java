package com.axpal.data.query;


import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;

import java.util.List;


/**
 * {@link com.querydsl.core.Tuple} turunden nesne donecek olan sorgularda kullanilmasi gereken siniftir.
 */
public class AxpalTupleQueryExpression extends AxpalQueryExpression {

    private List<Expression<?>> selectExpressionList;

    public AxpalTupleQueryExpression(List<Expression<?>> selectExpressionList) {
        this.selectExpressionList = selectExpressionList;
    }

    public AxpalTupleQueryExpression(Predicate whereClause, List<Expression<?>> selectExpressionList) {
        super(whereClause);
        this.selectExpressionList = selectExpressionList;
    }

    public AxpalTupleQueryExpression(Predicate whereClause,
                                    List<AxpalJoinExpression> joinExpressionList,
                                    List<Expression<?>> selectExpressionList) {
        super(whereClause, joinExpressionList);
        this.selectExpressionList = selectExpressionList;
    }

    public AxpalTupleQueryExpression(Predicate whereClause,
                                    List<AxpalJoinExpression> joinExpressionList,
                                    List<Expression<?>> selectExpressionList,
                                    boolean distinct) {
        super(whereClause, joinExpressionList, distinct);
        this.selectExpressionList = selectExpressionList;
    }

    public List<Expression<?>> getSelectExpressionList() {
        return selectExpressionList;
    }

    public void setSelectExpressionList(List<Expression<?>> selectExpressionList) {
        this.selectExpressionList = selectExpressionList;
    }
}
