package com.likone.cloud.likspace.resources.controller;

import com.likone.cloud.likspace.resources.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping
    public String createContract(@Valid @RequestBody ContractRequest contractRequest){
        return contractService.createContract(contractRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteContract(@PathVariable("id") String id){
        return contractService.deleteContract(id);
    }

    @PutMapping("/{id}")
    public ContractModel updateContract(@PathVariable("id") String id, @Valid @RequestBody ContractRequest contractRequest){
        return contractService.updateContract(id,contractRequest);
    }

    @GetMapping(value = "/{ids}")
    public List<ContractModel> queryContract(@PathVariable("ids") String[] ids){
        return contractService.queryContract(ids);
    }

    @GetMapping("/{id}/pay")
    public List<BillModel> queryPays(@PathVariable("id") String id){
        return null;
    }
}
