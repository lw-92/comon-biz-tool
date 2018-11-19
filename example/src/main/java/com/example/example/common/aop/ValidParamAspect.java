package com.example.example.common.aop;

import com.example.example.common.antation.ValidParam;
import com.example.example.common.dto.ValidationError;
import com.example.example.common.dto.ValidationResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 参数校验
 *
 * @author LIWEI
 * @date 2018-11-19
 * @since 1.0.0
 */
@Aspect
public class ValidParamAspect {
    private static final Validator FAILFAST_VALIDATOR = ((HibernateValidatorConfiguration) Validation.byProvider(HibernateValidator.class).configure()).failFast(true).buildValidatorFactory().getValidator();
    private static final Validator FAILOVER_VALIDATOR = ((HibernateValidatorConfiguration)Validation.byProvider(HibernateValidator.class).configure()).failFast(false).buildValidatorFactory().getValidator();

    @Before("@annotation(validParam)")
    public void beforeExecution( JoinPoint point, ValidParam validParam){
        Object[] arguments = point.getArgs();
        boolean failFast = validParam.failFast();
        boolean hibernateValidate = validParam.hibernateValidate();
        int hibernateErrorCode = validParam.hibernateErrorCode();
        Class<?> value = validParam.value();
        String handlerName = validParam.method().isEmpty() ? point.getSignature().getName() : validParam.method();
        ValidationResult result = ValidationResult.build();
        if (hibernateValidate) {
            // 执行Hibernate Validator校验
            javax.validation.Validator hibernateValidator = failFast ? FAILFAST_VALIDATOR : FAILOVER_VALIDATOR;
            for (Object argument : arguments) {
                result.addErrors(hibernateValidator.validate(argument).stream()
                        .map(v -> ValidationError.of(v.getPropertyPath().toString(), v.getMessage())
                                .invalidValue(v.getInvalidValue())
                                .errorCode(hibernateErrorCode)));

                if (failFast && !result.isSuccess()) {
                    throwFieldException(result);
                }
            }
        }
    }
    private void throwFieldException(ValidationResult result) {
        throw new IllegalArgumentException(result.getErrors().toString());
    }
}
