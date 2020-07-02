package com.likone.cloud.likspace.resources.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 分页封装
 * 颜涛
 * 2019年3月30日13:30:22
 * @param <T>
 */
public class CollectionResponse<T> {
    private Collection<T> result;
    private Long totalCount;

    public CollectionResponse(Collection<T> result) {
        if (CollectionUtils.isEmpty(result)) {
            this.setResult(new ArrayList());
            this.setTotalCount(Integer.valueOf(0));
        } else {
            this.setResult(result);
            this.setTotalCount(result.size());
        }

    }

    public CollectionResponse(Collection<T> result, Integer totalCount) {
        if (CollectionUtils.isEmpty(result)) {
            this.setResult(new ArrayList());
        } else {
            this.setResult(result);
        }

        this.totalCount = (long)totalCount.intValue();
    }

    public CollectionResponse(Collection<T> result, Long totalCount) {
        if (CollectionUtils.isEmpty(result)) {
            this.setResult(new ArrayList());
        } else {
            this.setResult(result);
        }

        this.totalCount = totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = (long)totalCount.intValue();
    }

    public Collection<T> getResult() {
        return this.result;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }


    public void setResult(Collection<T> result) {
        this.result = result;
    }


    public CollectionResponse() {
    }
}
