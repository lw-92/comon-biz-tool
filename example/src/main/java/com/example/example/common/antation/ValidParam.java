package com.example.example.common.antation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *对参数进行校验
 * @author LIWEI487
 * @date 2018-11-19
 * @since 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidParam {
    /**
     * 校验器列表
     */
    Class<?> value() default Void.class;

    /**
     * 方法名
     */
    String method() default "";

    /**
     * 是否启用failFast失败策略
     */
    boolean failFast() default true;

    /**
     * 是否执行hibernateValidate
     */
    boolean hibernateValidate() default true;

    /**
     * HibernateValidator校验错误码
     */
    int hibernateErrorCode() default 0;
}
