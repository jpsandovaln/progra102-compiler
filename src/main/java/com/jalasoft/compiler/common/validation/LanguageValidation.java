package com.jalasoft.compiler.common.validation;

import com.jalasoft.compiler.common.ConfigurationProperty;
import com.jalasoft.compiler.common.exception.InvalidDataException;

/**
 * @author HP
 * @version 1.1
 */
public class LanguageValidation implements IValidationStrategy {
    private String lang;

    public LanguageValidation(String lang) {
        this.lang = lang;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!ConfigurationProperty.getLanguages().contains(this.lang)) {
            throw new InvalidDataException("Invalid language");
        }
    }
}
