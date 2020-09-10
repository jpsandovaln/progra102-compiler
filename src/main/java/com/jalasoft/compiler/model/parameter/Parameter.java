package com.jalasoft.compiler.model.parameter;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class Parameter {
    private File file;

    public Parameter(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
