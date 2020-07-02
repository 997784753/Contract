package com.likone.cloud.likspace.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 水电条款(WaterElectricityTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WaterElectricityTerm")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class WaterElectricityTerm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 849584665082206195L;

    @JsonIgnore
    @OneToMany(mappedBy = "waterElectricityTerm")
    List<PromotionTerm> promotionTerms;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="contract_id",columnDefinition = "varchar(36) COMMENT'合同ID'")
    private LeaseContract contract;

   /**
    * 水费单价 元/吨
    */
    @Column(name="waterUnitPrice",columnDefinition = "varchar(50) COMMENT'水费单价'")
    private String waterUnitPrice;
    
        
   /**
    * 电费单价 元/度
    */
    @Column(name="electricUnitPrice",columnDefinition = "varchar(50) COMMENT'电费单价'")
    private String electricUnitPrice;
    

}