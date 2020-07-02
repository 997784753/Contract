package com.likone.cloud.likspace.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 合同表(Contract)实体类
 *
 * @author 颜涛
 * @date 2020-06-28 11:09:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LeaseContract extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 173620968626428675L;


    @Column(name = "org_id",columnDefinition = "varchar(36) COMMENT '组织id'")
    private String orgId;

    @Column(name = "site_id", columnDefinition = "varchar(36)   comment'站点Id'")
    private String siteId;

    @Column(name = "building_id", columnDefinition = "varchar(36)   comment'楼宇Id'")
    private String buildingId;

    @Column(name = "room_id", columnDefinition = "varchar(36)   comment'房源Id'")
    private String roomId;

    @CreatedDate
    @Column(name = "created_time",columnDefinition = "datetime COMMENT'创建时间'")
    private Date createdTime;

    @Column(name = "created_name",columnDefinition = "varchar(255) COMMENT'创建人名称'")
    private String createdName;

    @Column(name = "created_id",columnDefinition = "varchar(255) COMMENT'创建人Id'")
    private String createdId;

    @Column(name = "last_modified_id",columnDefinition = "varchar(255) COMMENT'最后修改人Id'")
    private String lastModifiedId;

    @Column(name = "last_modified_name",columnDefinition = "varchar(255) COMMENT'最后修改人'")
    private String lastModifiedName;

    @LastModifiedDate
    @Column(name = "last_modified_Time",columnDefinition = "datetime COMMENT'最后修改时间'")
    private Date lastModifiedTime;



   /**
    * 合同编号
    */
    @Column(name="contract_no",columnDefinition = "varchar(50) COMMENT'合同编号'")
    private String contractNo;

        
   /**
    * 跟进人
    */
    @Column(name="follow_id",columnDefinition = "varchar(50) COMMENT'跟进人'")
    private String followId;

    /**
     * 跟进人名
     */
    @Column(name="follow_name",columnDefinition = "varchar(50) COMMENT'跟进人名'")
    private String followName;

    /**
     * 法人
     */
    @Column(name = "Legal_person_id", columnDefinition = "varchar(255) COMMENT '法人'")
    private String LegalPersonId;

   /**
    * 签订人
    */
    @Column(name="signer_id",columnDefinition = "varchar(50) COMMENT'签订人'")
    private String signerId;

    /**
     * 租客联系人id
     */
    @Column(name = "tenant_id", columnDefinition = "varchar(255) COMMENT '租客联系人id'")
    private String tenantId;

    /**
     * 租客联系人名
     */
    @Column(name = "tenant_name", columnDefinition = "varchar(255) COMMENT '最后修改人Id'")
    private String tenantName;

    /**
     * 物业联系人
     */
    @Column(name = "property_contract_id", columnDefinition = "varchar(255) COMMENT '物业联系人'")
    private String propertyContractId;

   /**
    * 合同生效时间
    */
    @Column(name="start_date",columnDefinition = "Date COMMENT'合同计租时间'")
    private Date startDate;

   /**
    * 合同失效时间
    */
    @Column(name="end_date",columnDefinition = "Date COMMENT'合同失效时间'")
    private Date endDate;

    /**
     * 行业类型
     */
    @Column(name = "industry_name", columnDefinition = "varchar(20) COMMENT '行业类型'")
    private String industryName;
    



}