package com.likone.cloud.likspace.resources.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import com.likone.cloud.likspace.resources.entity.LeaseContract;
import com.likone.cloud.likspace.resources.repository.impl.ContractCustom;
import org.springframework.stereotype.Repository;
/**
 * 合同表数据库访问层
 *
 * @author 颜涛
 * @date 2020-06-28 14:16:09
 */
@Repository
public interface ContractRepository extends EntityGraphQuerydslPredicateExecutor<LeaseContract>,
        EntityGraphJpaRepository<LeaseContract, String>, ContractCustom {


}