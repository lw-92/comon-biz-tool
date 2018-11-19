package com.example.example.formData;

import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 *
 * @author LIWEI487
 * @date 2018-11-19
 * @since 1.0.0
 */
public class TestFormData {

    @NotNull
    private String testStr;
    @Range(max = 10,min=2)
    private Integer testInt;
    @Range(max = 10,min=2)
    private Double testDouble;
    @Range(max = 10,min=2)
    private Long testLong;
    @Future
    private Date testDate;
    @Valid
    private TestObj testObj;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public Integer getTestInt() {
        return testInt;
    }

    public void setTestInt(Integer testInt) {
        this.testInt = testInt;
    }

    public Double getTestDouble() {
        return testDouble;
    }

    public void setTestDouble(Double testDouble) {
        this.testDouble = testDouble;
    }

    public Long getTestLong() {
        return testLong;
    }

    public void setTestLong(Long testLong) {
        this.testLong = testLong;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public TestObj getTestObj() {
        return testObj;
    }

    public void setTestObj(TestObj testObj) {
        this.testObj = testObj;
    }
}
