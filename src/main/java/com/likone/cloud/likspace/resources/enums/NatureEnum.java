package com.likone.cloud.likspace.resources.enums;

/**
 * All rights Reserved, Designed By 灵控智能
 * Copyright:    Copyright(C) 2016-2019
 * Company   湖南灵控智能科技有限责任公司
 *
 * @project: likSpace
 * @Auther: 余雄
 * @Date: 2019年5月13日18:37:42
 * @Description:
 */
public enum NatureEnum {
    STANDARD("标准"),
    CUSTOMIZE("自定义");

    private String description;

    private NatureEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
