package com.example.example.controller;

import com.example.example.common.antation.ValidParam;
import com.example.example.controller.validate.TestFormDataValidate;
import com.example.example.formData.TestFormData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 测试 annotation 的aop
 * @author LIWEI487
 * @date 2018-11-19
 * @since 1.0.0
 */
@RestController
@RequestMapping("valid/test/")
public class ValidParamController {

    @PostMapping("test1")
    @ResponseBody
    @ValidParam(value = TestFormDataValidate.class, method = "validate", failFast =false )
    public void test1( @RequestBody TestFormData data){
        System.out.println(" success");
    }

    @GetMapping("test2")
    public void test2(){
        System.out.println(" success1");
        System.out.println(" success");
        System.out.println(" success2");
        System.out.println(" success4");
        System.out.println(" success5");
    }


}
