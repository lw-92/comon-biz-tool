package com.example.example.controller.log;

import com.example.example.common.antation.ValidParam;
import com.example.example.controller.BaseController;
import com.example.example.controller.validate.TestFormDataValidate;
import com.example.example.formData.TestFormData;
import org.springframework.web.bind.annotation.*;

/**
 * @author wei.li
 * @date 2018/11/19 21:10
 * @desc
 */
@RestController
@RequestMapping("log")
public class LogController extends BaseController {



    @PostMapping("test1")
    @ResponseBody
    public void test1( @RequestBody TestFormData data){
        System.out.println(" success");
        logger.info("info msg");
        logger.debug("debug msg");
        logger.error("error msg");
        logger.warn("warn msg");
    }
}
