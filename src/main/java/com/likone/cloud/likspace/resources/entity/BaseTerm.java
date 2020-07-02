package com.likone.cloud.likspace.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础条款(BaseTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:06:41
 */
@Entity
@Getter
@Setter
@Table(name = "BaseTerm")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

public class BaseTerm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 677050567734462832L;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="contractId",referencedColumnName="id")
    private LeaseContract contract;

   /**
    * 租赁数
    */
    @Column(name="areaSize",columnDefinition = "varchar(50) COMMENT'租赁数'")
    private String areaSize;
    
        
   /**
    * 租赁数单位
    */
    @Column(name="spaceUnit",columnDefinition = "varchar(50) COMMENT'租赁数单位'")
    private String spaceUnit;
    
        


    /**
     * 签订时间
     */
    @Column(name = "sign_date", columnDefinition = "datetime COMMENT '签订时间'")
    private Date signDate;

    /**
     * 计租开始时间
     */
    @Column(name = "lease_degin_date", columnDefinition = "datetime COMMENT '合同计租开始时间'")
    private Date leaseDeginDate;

    /**
     * 计租结束时间
     */
    @Column(name = "lease_end_Date", columnDefinition = "datetime COMMENT '合同计租结束时间'")
    private Date leaseEndDate;




}