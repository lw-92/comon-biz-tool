package com.example.example.common.antation;

import com.example.example.common.aop.ValidParamAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO: 请添加描述
 *
 * @author LIWEI487
 * @date 2018-11-19
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ValidParamAspect.class)
public @interface EnableValidator {
}
