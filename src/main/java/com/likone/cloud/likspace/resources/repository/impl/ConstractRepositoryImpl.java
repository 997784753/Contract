package com.likone.cloud.likspace.resources.repository.impl;

import com.likone.cloud.likspace.resources.entity.*;
import com.likone.cloud.likspace.resources.exceptions.BadRequestException;
import com.likone.cloud.likspace.resources.repository.ContractRepository;
import com.likone.cloud.likspace.resources.repository.LeaseTermRepository;
import com.likone.cloud.likspace.resources.repository.WaterElectricityTermRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstractRepositoryImpl implements ContractCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private LeaseTermRepository leaseTermRepository;

    @Autowired
    private WaterElectricityTermRepository waterElectricityTermRepository;

    @Override
    @Transactional
    public String createContract(ContractRequest contractRequest) {

        // 获得当前时间
//        Date getDate = Calendar.getInstance().getTime();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr = simpleDateFormat.format(getDate);

//        String dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getDate);
//        System.out.println("日期加时间:" + dateStr1);

        //还要获取修改人名和ID

        LeaseContract contract=new LeaseContract(contractRequest);
        contract.setIsDel(true);
        contractRequest.getBaseTerm().setIsDel(true);
        contractRequest.getTerminationTerm().setIsDel(true);
        //处理一下内部的优惠条款

        contractRequest.getLeaseTerms().forEach(
                leaseTerm -> {
                    leaseTerm.setIsDel(true);
//                    if(CollectionUtils.isNotEmpty(leaseTerm.getPromotionTerms())){
//                        leaseTerm.getPromotionTerms().forEach(
//                                promotionTerm -> {
//                                    promotionTerm.setIsDel(true);
//                                }
//                        );
//                    }
                }
        );
        contractRequest.getWaterElectricityTerms().forEach(
                waterElectricityTerm -> {
                    waterElectricityTerm.setIsDel(true);
//                    if(CollectionUtils.isNotEmpty(waterElectricityTerm.getPromotionTerms())){
//                        waterElectricityTerm.getPromotionTerms().forEach(
//                                promotionTerm -> {
//                                    promotionTerm.setIsDel(true);
//                                }
//                        );
//                    }
                }
        );
        if(CollectionUtils.isNotEmpty(contractRequest.getOverDueFineTerms())){
            contractRequest.getOverDueFineTerms().forEach(
                    overDueFineTerm -> {
                        overDueFineTerm.setIsDel(true);
                    }
            );
        }


        LeaseContract contractReturned=contractRepository.save(contract);

        return contractReturned.getId();
    }

    @Override
    @Transactional
    public Boolean deleteContract(String id) {
        LeaseContract contract=contractRepository.findById(id).orElseThrow(()->new BadRequestException("请求错误，资源不存在"));
        contract.setIsDel(false);

        JPAQueryFactory queryFactory=new JPAQueryFactory(entityManager);
        QBaseTerm baseTerm=QBaseTerm.baseTerm;
        queryFactory.update(baseTerm)
                .set(baseTerm.isDel,false)
                .where(baseTerm.contract.id.in(id))
                .execute();

        QDepositIncreasingRateTerm depositIncreasingRateTerm=QDepositIncreasingRateTerm.depositIncreasingRateTerm;
        queryFactory.update(depositIncreasingRateTerm)
                .set(depositIncreasingRateTerm.isDel,false)
                .where(depositIncreasingRateTerm.contract.id.in(id))
                .execute();

        QOverDueFineTerm overDueFineTerm=QOverDueFineTerm.overDueFineTerm;
        queryFactory.update(overDueFineTerm)
                .set(overDueFineTerm.isDel,false)
                .where(overDueFineTerm.contract.id.in(id))
                .execute();

        QTerminationTerm terminationTerm=QTerminationTerm.terminationTerm;
        queryFactory.update(terminationTerm)
                .set(terminationTerm.isDel,false)
                .where(terminationTerm.contract.id.in(id))
                .execute();

        //这两个下面包含优惠条款PromotionTerm所以要再深入删除一下
        QWaterElectricityTerm waterElectricityTerm=QWaterElectricityTerm.waterElectricityTerm;
        queryFactory.update(waterElectricityTerm)
                .set(waterElectricityTerm.isDel,false)
                .where(waterElectricityTerm.contract.id.in(id))
                .execute();


        QLeaseTerm leaseTerm=QLeaseTerm.leaseTerm;
        queryFactory.update(leaseTerm)
                .set(leaseTerm.isDel,false)
                .where(leaseTerm.contract.id.in(id))
                .execute();


        return true;
    }

    @Override
    public ContractModel updateContract(String id,ContractRequest contractRequest) {
        // 获得当前时间,保存最后修改时间
//        Date getDate = Calendar.getInstance().getTime();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr = simpleDateFormat.format(getDate);

//        String dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getDate);
//        System.out.println("日期加时间:" + dateStr1);

        //还要获取最后修改人id和名字
        LeaseContract contract=contractRepository.findById(id).orElseThrow(()->new BadRequestException("请求错误，资源不存在"));

        return contractMapper.covertContract(contractRepository.save(new LeaseContract(contractRequest)));
    }

    @Override
    public List<ContractModel> queryContract(String[] ids) {
        List<String> contractIds=contractRepository.findAll()
                .stream()
                .filter(contract -> !contract.getIsDel())
                .map(LeaseContract::getId)
                .collect(Collectors.toList());

        //确保所有的ID都是存在的
        if(contractIds.containsAll(Arrays.asList(ids))){
            return contractMapper.covertContracts(contractRepository.findAll());
        }else{
            throw new BadRequestException("无权操作或者资源不存在");
        }
    }
}
