package com.likone.cloud.likspace.resources.repository;

import com.likone.cloud.likspace.resources.entity.LeaseTerm;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
/**
 * (LeaseTerm)表数据库访问层
 *
 * @author 颜涛
 * @date 2020-06-29 17:11:46
 */
 @Repository
public interface LeaseTermRepository extends EntityGraphQuerydslPredicateExecutor<LeaseTerm>,
        EntityGraphJpaRepository<LeaseTerm, String> {


}