package com.jalasoft.compiler.common.validation;

import com.jalasoft.compiler.common.exception.InvalidDataException;

/**
 * @author HP
 * @version 1.1
 */
public class NotNullOrEmpty implements IValidationStrategy {
    private String value;
    private String field;

    public NotNullOrEmpty(String field, String value) {
        this.value = value;
        this.field = field;
    }
    @Override
    public void validate() throws InvalidDataException {
        System.out.println(this.value);
        if (this.value == null || this.value.trim().isEmpty()) {
            throw new InvalidDataException("Invalid data on field = " + this.field);
        }
    }
}
