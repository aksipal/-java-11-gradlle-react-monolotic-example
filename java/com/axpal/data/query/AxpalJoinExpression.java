package com.axpal.data.query;

import com.querydsl.core.JoinType;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;

import java.io.Serializable;


/**
 * {@link  com.querydsl.core.Tuple} turunden nesne donecek olan sorgularda kullanilmasi gereken siniftir.
 */
public class AxpalJoinExpression implements Serializable {

    private final JoinType type;

    private final EntityPath<?> joinClause;

    private Path<?>alias;

    private Predicate[] onClause;

    public AxpalJoinExpression(JoinType type, EntityPath<?> joinClause) {
        this.type = type;
        this.joinClause = joinClause;
    }

    public AxpalJoinExpression(JoinType type, EntityPath<?> joinClause, Path<?> alias) {
        this.type = type;
        this.joinClause = joinClause;
        this.alias = alias;
    }

    public AxpalJoinExpression(JoinType type, EntityPath<?> joinClause, Path<?> alias, Predicate[] onClause) {
        this.type = type;
        this.joinClause = joinClause;
        this.alias = alias;
        this.onClause = onClause;
    }

    public JoinType getType() {
        return type;
    }

    public EntityPath<?> getJoinClause() {
        return joinClause;
    }

    public Path<?> getAlias() {
        return alias;
    }

    public Predicate[] getOnClause() {
        return onClause;
    }
}
