package anotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wei.li
 * @date 2018/11/18 9:11
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(autoconfig.FileAutoConfig.class)
public @interface EnableFileService {
}
