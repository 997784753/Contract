package com.likone.cloud.likspace.resources.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(
        validatedBy = {ContractValidator.class}
)
public @interface ValidateContract {

    String message() default "合同抄录不完整";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
