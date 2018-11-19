package com.example.example.formData;

import javax.validation.constraints.Max;

/**
 *
 *
 * @author LIWEI487
 * @date 2018-11-19
 * @since 1.0.0
 */
public class TestObj {
    @Max(10)
    private Integer testInteger;

    public Integer getTestInteger() {
        return testInteger;
    }

    public void setTestInteger(Integer testInteger) {
        this.testInteger = testInteger;
    }
}
