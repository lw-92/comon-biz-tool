package com.example.example.common.dto;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author LIWEI
 * @date 2018-11-19
 * @since 1.0.0
 */
public final class ValidationError {
    private final String errorMsg;
    private final Object[] params;
    private final String field;
    private int errorCode;
    private Object invalidValue;

    /**
     * Constructs a {@code ValidationError} from {@code errorMsg}.
     *
     * @param errorMsg The error message
     * @param params   The params of error message.
     * @param
     */
    private ValidationError(String field, String errorMsg, Object[] params) {
        this.field = field;
        this.errorMsg = errorMsg;
        this.params = params;
    }

    /**
     * Constructs a {@code ValidationError} from {@code errorMsg}.
     *
     * @param errorMsg The error message.
     * @param params   The params of error message.
     * @return The {@code ValidationError} instance.
     * @throws NullPointerException if {@code errorMsg} is null
     */
    public static ValidationError of(String field, String errorMsg, Object... params) {
        Objects.requireNonNull(errorMsg, "errorMsg is null");
        Objects.requireNonNull(field, "field is null");
        return new ValidationError(field, errorMsg, params);
    }

    /**
     * Set error code.
     *
     * @param errorCode The error code.
     * @return The {@code ValidationError} instance.
     */
    public final ValidationError errorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Set invalid value object.
     *
     * @param invalidValue The invalid object.
     * @return The {@code ValidationError} instance.
     */
    public final ValidationError invalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Object[] getParams() {
        return params;
    }

    public String getField() {
        return field;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMsg, Arrays.hashCode(params), field, errorCode, invalidValue);
    }

    @Override
    public String toString() {
        return String.format("ValidationError{errorMsg='%s', params='%s',errorCode=%d, field='%s', invalidValue=%s}",
                errorMsg, Arrays.toString(params), errorCode, field, invalidValue);
    }
}
