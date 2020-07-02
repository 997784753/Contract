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
 * 退租协议(TerminationTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TerminationTerm")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TerminationTerm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 839333631066163713L;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="contractId",referencedColumnName="id")
    private LeaseContract contract;
    
        
   /**
    * 审核状态
    */
    @Column(name="auditStatus",columnDefinition = "varchar(50) COMMENT'审核状态'")
    private String auditStatus;
    


   /**
    * 保证金总额
    */
    @Column(name="depositPaid",columnDefinition = "varchar(50) COMMENT'保证金总额'")
    private String depositPaid;
    

        
   /**
    * 租金总额
    */
    @Column(name="leasePaid",columnDefinition = "varchar(50) COMMENT'租金总额'")
    private String leasePaid;
    
        
   /**
    * 应收款总额
    */
    @Column(name="leasereceivable",columnDefinition = "varchar(50) COMMENT'应收款总额'")
    private String leasereceivable;
    
        
   /**
    * 违约金应收
    */
    @Column(name="liquidatedDamagesReceivable",columnDefinition = "varchar(50) COMMENT'违约金应收'")
    private String liquidatedDamagesReceivable;
    
        
   /**
    * 签署日期
    */
    @Column(name="signDate",columnDefinition = "Date COMMENT'签署日期'")
    private Date signDate;

    /**
     * 租客名称
     */
    @Column(name = "tenant", columnDefinition = "varchar(36) COMMENT '租客名称'")
    private String tenant;

    /**
     * 租客ID
     */
    @Column(name = "tenantId", columnDefinition = "varchar(36) COMMENT '租客ID'")
    private String tenantId;

    /**
     * 总面积
     */
    @Column(name = "total_paid", columnDefinition = "decimal COMMENT '总面积'")
    private double totalPaid;

    /**
     * 总应收金额
     */
    @Column(name = "total_receivable", columnDefinition = "decimal COMMENT '总应收'")
    private double totalReceivable;

    /**
     * 总金额
     */
    @Column(name = "total_amount", columnDefinition = "varchar(36) COMMENT '总计'")
    private String totalAmount;



}