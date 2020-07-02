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
 * 优惠条款(PromotionTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PromotionTerm")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class PromotionTerm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -39798620785467339L;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="waterElectricityTermId",columnDefinition = "varchar(36) COMMENT'水电条款ID'")
    private WaterElectricityTerm waterElectricityTerm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="lease_term_id",columnDefinition = "varchar(36) COMMENT'租期条款ID'")
    private LeaseTerm leaseTerm;

    /**
     * 为了方便后续删除操作，这里加上合同id
     */
    @Column(name="contractId",columnDefinition = "varchar(36) COMMENT'合同ID'")
    private String contractId;

        
   /**
    * 开始时间
    */
    @Column(name="beginDate",columnDefinition = "Date COMMENT'开始时间'")
    private Date beginDate;
    
        
   /**
    * 结束时间
    */
    @Column(name="endDate",columnDefinition = "Date COMMENT'结束时间'")
    private Date endDate;


    /**
     *  折扣类型（枚举）RENTFREE(免租期) TRIM(装修期)   DISCOUNT(单价折扣) REMISSION(减免金额) UNITPRICE(单价减免)
     */
    @Column(name = "discount_enum", columnDefinition = "varchar(36) COMMENT '折扣类型（枚举）RENTFREE(免租期) TRIM(装修期)   DISCOUNT(单价折扣) REMISSION(减免金额) UNITPRICE(单价减免)'")
    private String discountEnum;
    
        
   /**
    * 折扣数
    */
    @Column(name="discountNumber",columnDefinition = "int COMMENT'折扣数'")
    private Integer discountNumber;
    
        
   /**
    * 减免金额
    */
    @Column(name="freeMoney",columnDefinition = "varchar(50) COMMENT'减免金额'")
    private String freeMoney;

    /**
     *  备注
     */
    @Column(name = "remark", columnDefinition = "varchar(36) COMMENT '备注'")
    private String remark;



}