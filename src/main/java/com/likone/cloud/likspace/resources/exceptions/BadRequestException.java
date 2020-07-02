package com.likone.cloud.likspace.resources.exceptions;

import com.likone.cloud.likspace.resources.enums.ErrorCodeEnum;

public class BadRequestException extends RuntimeException{
    /**
     * 异常码
     */
    protected Integer code;

    public BadRequestException(String errorMsg){
        super(errorMsg);
        this.code= ErrorCodeEnum.PRODUCT66660001.code();
    }

    public BadRequestException(String errorMsg,int code){
        super(errorMsg);
        this.code= code;
    }

}
