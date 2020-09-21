package com.jalasoft.compiler.model.parameter;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class PythonParameter extends Parameter {
    private String pythonFolder;

    public PythonParameter(File file, String pythonFolder) {
        super(file);
        this.pythonFolder = pythonFolder;
    }

    public String getPythonFolder() {
        return pythonFolder;
    }

    public void setPythonFolder(String pythonFolder) {
        this.pythonFolder = pythonFolder;
    }
}
