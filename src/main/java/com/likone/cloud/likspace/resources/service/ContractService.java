package com.likone.cloud.likspace.resources.service;

import com.likone.cloud.likspace.resources.exceptions.BadRequestException;
import com.likone.cloud.likspace.resources.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    /**
     * 新增合同
     * @param contractRequest
     * @return 新增合同的ID
     */
    public String createContract(ContractRequest contractRequest){
        return contractRepository.createContract(contractRequest);
    }

    /**
     * 删除合同
     * @param id
     * @return
     */
    public String deleteContract(String id){
        try {
            contractRepository.deleteContract(id);
            return "删除成功";
        }catch (BadRequestException e){
            return e.getMessage();
        }
    }

    /**
     * 修改合同
     * @param contractRequest
     * @return 修改后的合同
     */
    public ContractModel updateContract(String id,ContractRequest contractRequest){
        return contractRepository.updateContract(id,contractRequest);
    }

    /**
     * 查询合同
     * @param ids
     * @return
     */
    public List<ContractModel> queryContract(String[] ids){
        return contractRepository.queryContract(ids);
    }
}
