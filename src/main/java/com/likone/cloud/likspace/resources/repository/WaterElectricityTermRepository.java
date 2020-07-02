package com.likone.cloud.likspace.resources.repository;

import com.likone.cloud.likspace.resources.entity.WaterElectricityTerm;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
/**
 * (WaterElectricityTerm)表数据库访问层
 *
 * @author 颜涛
 * @date 2020-06-29 17:11:46
 */
 @Repository
public interface WaterElectricityTermRepository extends EntityGraphQuerydslPredicateExecutor<WaterElectricityTerm>,
        EntityGraphJpaRepository<WaterElectricityTerm, String> {


}