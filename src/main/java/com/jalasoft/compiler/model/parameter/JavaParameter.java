package com.jalasoft.compiler.model.parameter;

import com.jalasoft.compiler.model.exception.CommandException;

import java.io.File;

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

    public void validate() throws CommandException {
        if (this.javaFolder == null || "".equals(this.javaFolder)) {
            throw new CommandException("failed");
        }
    }
}
