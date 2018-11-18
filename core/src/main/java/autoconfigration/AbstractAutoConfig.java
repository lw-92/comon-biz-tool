package autoconfigration;

import dto.CommonProperties;
import utils.ValidateUtil;
import javax.annotation.Resource;
import javax.validation.Validator;


/**
 * @author wei.li
 * @date 2018/11/17 21:56
 * @desc
 */
public abstract class AbstractAutoConfig<k extends CommonProperties> {
    @Resource(name="jsr303Validator")
    private Validator validator;
    protected final k properties;

    public AbstractAutoConfig(k properties) {
        this.properties = properties;
    }

    protected final void validate(){
        ValidateUtil.validate(validator,properties);
    }


}
