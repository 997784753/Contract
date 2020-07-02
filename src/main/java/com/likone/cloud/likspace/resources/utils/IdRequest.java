package com.likone.cloud.likspace.resources.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 鄢威
 * @date 2020/5/12 20:08:05
 * id请求封装
 */
@Getter
@Setter
public class IdRequest {

    /**
     * id
     */
    private String Id;

    /**
     * 组织id
     */
    private String orgId;
    /**
     * 站点id
     */
    private String siteId;
    /**
     * 企业id
     */
    private String businessId;
    /**
     * 楼宇id
     */
    private String buildId;
    /**
     * 创建人id
     */
    private String createdId;
    /**
     * 店铺id
     */
    private String shopId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 活动id
     */
    private String activeId;
    /**
     * 卡券id
     */
    private String couponId;
    /**
     * 促销id
     */
    private String promotionId;

    /**
     * 父id
     */
    private String parent;
}
