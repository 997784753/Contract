package com.likone.cloud.likspace.resources.utils;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * All rights Reserved,Designed By 灵控智能
 * Copyright:    Copyright(C) 2016-2019
 * Company   湖南灵控智能科技有限责任公司
 *
 * @project:
 * @Auther:李疆龙
 * @Date:2020/4/9 16:07
 * Description:
 */
@Data
public class PageInfo {
    /**
     * 当前页
     */
    private Integer page = 1;

    /**
     * 每页条数
     */
    private Integer size = 15;

    /**
     * 默认倒序
     */
    private Sort.Direction direction= Sort.Direction.DESC;
    /**
     * 创建时间
     */
    private String sort = "createdTime";
}

 