package com.jalasoft.compiler.model.parameter;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.common.validation.IValidationStrategy;
import com.jalasoft.compiler.common.validation.NotNullOrEmpty;
import com.jalasoft.compiler.common.validation.ValidationContext;
import com.jalasoft.compiler.model.exception.CommandException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class JavaParameter extends Parameter {
    private String javaFolder;

    public JavaParameter(File file, String javaFolder) {
        super(file);
        this.javaFolder = javaFolder;
    }

    public String getJavaFolder() {
        return javaFolder;
    }

    public void setJavaFolder(String javaFolder) {
        this.javaFolder = javaFolder;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategyList = new ArrayList<>();
        validationStrategyList.add(new NotNullOrEmpty("javaFolder", this.javaFolder));

        ValidationContext context = new ValidationContext(validationStrategyList);
        context.validation();
    }
}
