package com.likone.cloud.likspace.resources.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * All rights Reserved, Designed By 灵控智能
 * Copyright:    Copyright(C) 2016-2019
 * Company   湖南灵控智能科技有限责任公司
 *
 * @project: likSpace
 * @Auther: 余雄
 * @Date: 2019/7/9 16:49
 * @Description: 基础字段
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    @Column(name = "id", unique = true, nullable = false, length = 36)
    private String id;



    @Column(name = "is_del",columnDefinition = "bit(1) COMMENT'是否删除'")
    private Boolean isDel;
}
