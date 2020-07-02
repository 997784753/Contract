package com.likone.cloud.likspace.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 滞纳金条款(OverDueFineTerm)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OverDueFineTerm")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OverDueFineTerm  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 521719161683085104L;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="contract_id",columnDefinition = "varchar(36) COMMENT'合同ID'")
    private LeaseContract contract;
        
   /**
    * 比例%/天
    */
    @Column(name="rate",columnDefinition = "varchar(50) COMMENT'比例%/天'")
    private String rate;
    
        
   /**
    * 滞纳金上限%
    */
    @Column(name="upperLimitRate",columnDefinition = "varchar(50) COMMENT'滞纳金上限%'")
    private String upperLimitRate;
    


}