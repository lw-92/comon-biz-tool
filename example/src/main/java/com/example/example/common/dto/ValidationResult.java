package com.example.example.common.dto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author LIWEI
 * @date 2018-11-19
 * @since 1.0.0
 */
public class ValidationResult {

    private List<ValidationError> errors = new LinkedList<>();

    private boolean success = true;

    private int globalErrorCode;

    private String globalErrorMessage;

    private long timeElapsed;

    /**
     * Constructs a {@code ValidationResult}.
     */
    private ValidationResult() {

    }

    /**
     * Constructs a {@code ValidationResult}.
     *
     * @return The instance of {@code ValidationResult}.
     */
    public static ValidationResult build() {
        return new ValidationResult();
    }

    /**
     * 添加全局错误
     *
     * @param globalErrorCode
     * @param globalErrorMessage
     * @return
     */
    public final ValidationResult addGlobalError(int globalErrorCode, String globalErrorMessage) {
        Objects.requireNonNull(globalErrorMessage, "globalErrorMessage is null");
        this.globalErrorCode = globalErrorCode;
        this.globalErrorMessage = globalErrorMessage;
        success = false;
        return this;
    }

    /**
     * 添加全局错误
     *
     * @param globalErrorMessage
     * @return
     */
    public final ValidationResult addGlobalError(String globalErrorMessage) {
        this.globalErrorMessage = Objects.requireNonNull(globalErrorMessage, "error is null");
        success = false;
        return this;
    }

    /**
     * Add an {@code ValidationError}
     *
     * @param error The {@code ValidationError}
     * @return The instance of {@code ValidationResult} itself.
     * @throws NullPointerException if {@code error} is null
     */
    public final ValidationResult addError(ValidationError error) {
        Objects.requireNonNull(error, "error is null");
        errors.add(error);
        success = false;
        return this;
    }

    /**
     * Add errors of {@code ValidationError}.
     *
     * @param errors The array of {@code ValidationError}
     * @return The instance of {@code ValidationResult} itself.
     * @throws NullPointerException if {@code errors} is null.
     */
    public ValidationResult addErrors(ValidationError... errors) {
        Objects.requireNonNull(errors, "errors is null");
        return addErrors(Stream.of(errors));
    }

    /**
     * Add errors of {@code ValidationError}.
     *
     * @param errors A stream of {@code ValidationError}
     * @return The instance of {@code ValidationResult} itself.
     * @throws NullPointerException if {@code errors} is null.
     */
    public ValidationResult addErrors(Stream<ValidationError> errors) {
        Objects.requireNonNull(errors, "errors is null");
        return addErrors(errors.collect(Collectors.toList()));
    }

    /**
     * Add errors of {@code ValidationError}.
     *
     * @param errors A collection of {@code ValidationError}
     * @return The instance of {@code ValidationResult} itself.
     * @throws NullPointerException if {@code errors} is null.
     */
    public ValidationResult addErrors(Collection<ValidationError> errors) {
        Objects.requireNonNull(errors, "errors is null");
        if (errors.isEmpty()) {
            return this;
        }
        this.errors.addAll(errors);
        success = false;
        return this;
    }

    /**
     * Set the {@code timeElapsed} of validation
     *
     * @param timeElapsed The time elapsed of validation
     * @return The instance of {@code ValidationResult} itself.
     */
    public final ValidationResult timeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getGlobalErrorCode() {
        return globalErrorCode;
    }

    public String getGlobalErrorMessage() {
        return globalErrorMessage;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(globalErrorCode, globalErrorMessage, errors, timeElapsed, success);
    }

    @Override
    public String toString() {
        return String.format("ValidationResult{success=%d, globalErrorCode=%d, globalErrorMessage='%s', "
                        + "errors='%s', timeElapsed=%d}",
                success, globalErrorCode, globalErrorMessage, errors.toString(), timeElapsed);
    }
}
