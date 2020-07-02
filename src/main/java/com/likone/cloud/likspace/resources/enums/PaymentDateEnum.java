package com.likone.cloud.likspace.resources.enums;

/**
 * 提前时间类型
 */
public enum PaymentDateEnum {
    NATURALDAY("自然日"),
    WORKDAY("工作日"),
    APPOINTEDDAY("指定日期");

    private String desc;

    PaymentDateEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
