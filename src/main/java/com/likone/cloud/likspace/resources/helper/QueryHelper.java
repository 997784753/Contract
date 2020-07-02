package com.likone.cloud.likspace.resources.helper;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * Created by rk on 2017/9/26.
 */
public class QueryHelper {

    public static <E extends Enum<E>> NumberExpression<Integer> getNumberExpressionForEnumPath(EnumPath<E> path, Class<E> elementType) {

        List<E> set = new ArrayList<>(EnumSet.allOf(elementType));

        CaseBuilder builder = new CaseBuilder();
        CaseBuilder.Cases<Integer, NumberExpression<Integer>> cases = null;
        for (int i = 0; i < set.size(); i++) {
            if (null == cases) {
                cases = builder.when(path.eq(set.get(i))).then(i);
            } else {
                cases = cases.when(path.eq(set.get(i))).then(i);
            }
        }
        return cases != null ? cases.otherwise(100) : null;
    }


    public static <T> JPAQuery<T> applySort(JPAQuery<T> query, Sort sort, Map<String, ComparableExpressionBase> sortPathMap) {

        sort.forEach(
                order -> {
            ComparableExpressionBase expression = sortPathMap.get(order.getProperty());
            if (null != expression) {
                query.orderBy(order.isAscending() ? expression.asc() : expression.desc());
            }
        });
        return query;
    }

    public static <T> PageImpl<T> applyPage(JPAQuery<T> query, Pageable pageable) {
        Long count = query.fetchCount();
        if (pageable != null) {
            query.offset(pageable.getOffset());
            query.limit(pageable.getPageSize());
        } else {
            pageable = Pageable.unpaged();
        }
        return new PageImpl<>(query.fetch(), pageable, count);
    }
}
