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
import java.util.List;

/**
 * 租期条款(LeaseTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LeaseTerm")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LeaseTerm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -23996000400754721L;

    @JsonIgnore
    @OneToMany(mappedBy = "leaseTerm")
    private List<PromotionTerm> promotionTerms;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="contractId",columnDefinition = "varchar(36) COMMENT'合同ID'")
    private LeaseContract contract;
        
   /**
    * 计算枚举 MONTHLY("按月计费"), PERDIEM("按实际天数计费");
    */
    @Column(name="calculateEnum",columnDefinition = "varchar(50) COMMENT'计算枚举'")
    private String calculateEnum;
    
        
   /**
    * 一年算多少天
    */
    @Column(name="dayNumberForYear",columnDefinition = "varchar(50) COMMENT'一年算多少天'")
    private String dayNumberForYear;
    
        
   /**
    * 几月一付
    */
    @Column(name="intervalMonth",columnDefinition = "int COMMENT'几月一付'")
    private Integer intervalMonth;
    
        
   /**
    * 付款提前时间
    */
    @Column(name="payInAdvanceDay",columnDefinition = "int COMMENT'付款提前时间'")
    private Integer payInAdvanceDay;


    /**
     * 提前时间类型（枚举） NATURALDAY(自然日) WORKDAY(工作日)  APPOINTEDDAY(指定日期)
     */
    @Column(name="paymentDateEnum",columnDefinition = "varchar(50) COMMENT'提前时间类型 NATURALDAY(自然日),WORKDAY(工作日),APPOINTEDDAY(指定日期)'")
    private String paymentDateEnum;

    /**
     * 合同单价
     */
    @Column(name = "price", columnDefinition = "decimal COMMENT '合同单价'")
    private double price;

    /**
     * 合同单价枚举  D("元/㎡·天"), M("元/㎡·月"), YM("元/月"), YD("元/天"), GD("元/工位·天"), GM("元/工位·月");
     */
    @Column(name = "price_unit_enum", columnDefinition = "varchar(36) COMMENT '合同单价枚举  D(元/㎡·天), M(元/㎡·月), YM(元/月), YD(元/天), GD(元/工位·天), GM(元/工位·月);'")
    private String priceUnitEnum;
        
   /**
    * 开始时间
    */
    @Column(name="termBeginDate",columnDefinition = "Date COMMENT'开始时间'")
    private Date termBeginDate;
    
        
   /**
    * 结束时间
    */
    @Column(name="termEndDate",columnDefinition = "Date COMMENT'结束时间'")
    private Date termEndDate;


    /**
     * 租期划分规则 枚举   STARTINGDATE(按起始日划分) THENEXTMONTH(次月按自然月划分(仅一月一付有效)) FirstBill(按自然月划分(首月非整自然月划入第一期)) CalculateAMonth(按自然月划分(首月非整自然月算一个月))
     */
    @Column(name = "lease_divide_role_enum", columnDefinition = "varchar(50) COMMENT '租期划分规则 枚举   STARTINGDATE(按起始日划分) THENEXTMONTH(次月按自然月划分(仅一月一付有效)) FirstBill(按自然月划分(首月非整自然月划入第一期)) CalculateAMonth(按自然月划分(首月非整自然月算一个月))'")
    private String leaseDivideRoleEnum;

    /**
     *  天单价换算规则 YEAR(按年换算：天单价=月单价*12/年天数) MONTH(按自然月换算：天单价=月单价/自然月的天数)
     */
    @Column(name = "month_price_convert_role_enum", columnDefinition = "varchar(36) COMMENT '天单价换算规则 YEAR(按年换算：天单价=月单价*12/年天数) MONTH(按自然月换算：天单价=月单价/自然月的天数)'")
    private String monthPriceConvertRoleEnum;

    /**
     * 货币单位
     */
    @Column(name = "monetary_unit", columnDefinition = "varchar(36) COMMENT '货币单位'")
    private String monetaryUnit;







    /*合同押金*/
    /**
     * 押金
     */
    @Column(name="deposit",columnDefinition = "int(50) COMMENT'押金'")
    private Integer deposit;


    /**
     * 押金单位 YUAN 元 MONTH 月
     */
    @Column(name="depositUnitEnum",columnDefinition = "varchar(50) COMMENT'押金单位'")
    private String depositUnitEnum;


    /*合同押金递增*/
    /**
     * 初始递增日期
     */
    @Column(name = "apply_date", columnDefinition = "Date COMMENT'递增日期'")
    private Date applyDate;

    /**
     * 间隔 (枚举) YEAR(年),MOUTH(月);
     */
    @Column(name = "timeInterval", columnDefinition = "varchar(36) COMMENT'间隔YEAR(年),MOUTH(月)'")
    private String timeInterval;

    /**
     * 递增类型（枚举） PERCENT(%) MONEY(元)
     */
    @Column(name = "increaseRataEnum", columnDefinition = "varchar(36) COMMENT'递增类型PERCENT(%),MONEY(元)'")
    private String increaseRataEnum;

    /**
     * 递增数量
     */
    @Column(name = "count", columnDefinition = "varchar(36) COMMENT'递增数量'")
    private String count;



}