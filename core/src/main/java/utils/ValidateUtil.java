package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author wei.li
 * @date 2018/11/17 22:04
 * @desc
 */
public class ValidateUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(ValidateUtil.class);

    public static <T> void validate(Validator validator, T properties){
        final Set<ConstraintViolation<T>> validate = validator.validate(properties);
        if(validate.size()>0){
            validate.forEach(v->{
                LOGGER.error(v.getRootBean().getClass().getSimpleName()+": "+v.getPropertyPath()+
                "\r"+v.getMessage());
            });
            throw new ConstraintViolationException(validate);
        }
    }
}
