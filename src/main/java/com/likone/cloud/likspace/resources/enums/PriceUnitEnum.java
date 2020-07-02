package com.likone.cloud.likspace.resources.enums;

/**
 * 合同单价枚举
 */
public enum PriceUnitEnum {
    D("元/㎡·天"),
    M("元/㎡·月"),
    YM("元/月"),
    YD("元/天"),
    GD("元/工位·天"),
    GM("元/工位·月");

    private String desc;

    PriceUnitEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
