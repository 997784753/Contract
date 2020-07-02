package com.likone.cloud.likspace.resources.enums;

/**
 * 付款类型
 */
public enum billEnum {
    DEPOSIT("押金"),
    RENT("租金"),
    ENERGYCONSUM("能耗费"),
    PROPERTY("物业费"),
    RENT_DEPOSIT("租金保证金"),
    PROPERTY_DEPOSIT("物业保证金"),
    OTHER("其他");

    private String desc;

    billEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
