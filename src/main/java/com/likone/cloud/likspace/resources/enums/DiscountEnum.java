package com.likone.cloud.likspace.resources.enums;

/**
 * 折扣类型
 */
public enum DiscountEnum {
    RENTFREE("免租期"),
    TRIM("装修期"),
    DISCOUNT("单价折扣"),
    REMISSION("减免金额"),
    UNITPRICE("单价减免");

    private String desc;

    DiscountEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
