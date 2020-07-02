package com.likone.cloud.likspace.resources.enums;

/**
 * 租期划分规则
 */
public enum LeaseDivideRoleEnum {
    STARTINGDATE("按起始日划分"),
    THENEXTMONTH("次月按自然月划分(仅一月一付有效)"),
    FirstBill("按自然月划分(首月非整自然月划入第一期)"),
    CalculateAMonth("按自然月划分(首月非整自然月算一个月)");

    private String desc;

    LeaseDivideRoleEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
