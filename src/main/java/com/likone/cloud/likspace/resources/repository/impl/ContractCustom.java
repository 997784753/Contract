package com.likone.cloud.likspace.resources.repository.impl;

import java.util.List;

public interface ContractCustom {
    /**
     * 新增合同
     * @param contractRequest
     * @return 新增合同的id
     */
    String createContract(ContractRequest contractRequest);

    /**
     * 删除合同
     * @param id 合同id
     * @return 是否成功
     */
    Boolean deleteContract(String id);

    /**
     * 修改合同
     * @param contractRequest
     * @return 修改后的合同
     */
    ContractModel updateContract(String id,ContractRequest contractRequest);

    /**
     * 查询合同
     * @param ids
     * @return
     */
    List<ContractModel> queryContract(String[] ids);
}
