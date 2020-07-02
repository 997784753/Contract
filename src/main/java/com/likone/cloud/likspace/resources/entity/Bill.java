package com.likone.cloud.likspace.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 账单(pay)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:05
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pay")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Bill extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -40812144180700935L;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="contract_id",columnDefinition = "varchar(36) COMMENT'合同ID'")
    private LeaseContract contract;

    /**
     * 组织ID
     */
    @Column(name = "org_id",columnDefinition = "varchar(36) COMMENT '组织id'")
    private String orgId;

    /**
     * 站点ID
     */
    @Column(name = "site_id", columnDefinition = "varchar(36)   comment'站点Id'")
    private String siteId;

    @CreatedDate
    @Column(name = "created_time",columnDefinition = "datetime COMMENT'创建时间'")
    private Date createdTime;

   /**
    * 开始时间
    */
    @Column(name="startDate",columnDefinition = "Date COMMENT'开始时间'")
    private Date startDate;
    
        
   /**
    * 结束时间
    */
    @Column(name="endDate",columnDefinition = "Date COMMENT'结束时间'")
    private Date endDate;


   /**
    * 最终单价
    */
    @Column(name="finalPrice",columnDefinition = "varchar(50) COMMENT'最终单价'")
    private String finalPrice;

    /**
     * 单位 D("元/㎡·天"), M("元/㎡·月"), YM("元/月"), YD("元/天"), GD("元/工位·天"), GM("元/工位·月");
     */
    @Column(name = "price_unit_enum", columnDefinition = "varchar(36) COMMENT '单位 D(元/㎡·天), M(元/㎡·月), YM(元/月), YD(元/天), GD(元/工位·天), GM(元/工位·月);'")
    private String priceUnitEnum;

    /**
     * 付款类型 枚举：DEPOSIT("押金"), RENT("租金"), ENERGYCONSUM("能耗费"), PROPERTY("物业费"), RENT_DEPOSIT("租金保证金"), PROPERTY_DEPOSIT("物业保证金"), OTHER("其他");
     */
    @Column(name = "pay_enum", columnDefinition = "varchar(36) COMMENT '付款类型 枚举：DEPOSIT(押金), RENT(租金), ENERGYCONSUM(能耗费), PROPERTY(物业费), RENT_DEPOSIT(租金保证金), PROPERTY_DEPOSIT(物业保证金), OTHER(其他);'")
    private String payEnum;

   /**
    * 付款日期
    */
    @Column(name="theoryPayDate",columnDefinition = "Date COMMENT'付款日期'")
    private Date theoryPayDate;
    
        
   /**
    * 最终金额
    */
    @Column(name="theoryPayMoney",columnDefinition = "varchar(50) COMMENT'最终金额'")
    private String theoryPayMoney;

   /**
    * 币种（人民币CNY)
    */
    @Column(name="monetaryUnit",columnDefinition = "varchar(50) COMMENT'币种（人民币CNY)'")
    private String monetaryUnit;
    

    public Bill(BillRequest info){

        setCreatedTime(info.getCreatedTime());
        setEndDate(info.getEndDate());
        setFinalPrice(info.getFinalPrice());
        setMonetaryUnit(info.getMonetaryUnit());
        setOrgId(info.getOrgId());
        setPayEnum(info.getPayEnum());
        setPriceUnitEnum(info.getPriceUnitEnum());
        setSiteId(info.getSiteId());
        setStartDate(info.getStartDate());
        setTheoryPayDate(info.getTheoryPayDate());
        setTheoryPayMoney(info.getTheoryPayMoney());
        setContract(info.getContract());
    }

}