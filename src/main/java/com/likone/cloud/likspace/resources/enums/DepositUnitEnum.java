package com.likone.cloud.likspace.resources.enums;

/**
 * 押金单位
 */
public enum DepositUnitEnum {
    YUAN("元"),
    HUNDRED("百"),
    THOUSAND("千");

    private String desc;

    DepositUnitEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
