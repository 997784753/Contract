package com.likone.cloud.likspace.resources.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContractValidator implements ConstraintValidator<ValidateContract,ContractRequest> {

    @Override
    public void initialize(ValidateContract constraintAnnotation) {
        //一些初始化的操作
    }

    @Override
    public boolean isValid(ContractRequest value, ConstraintValidatorContext context) {
        //此方法写校验具体实现
        return false;
    }
}
