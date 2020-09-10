package com.jalasoft.compiler.controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HP
 * @version 1.1
 */
@Component
@ConfigurationProperties(prefix = "execute.java")
public class JavaPropeties {
    private String projectFolder;
    private String version8;

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getVersion8() {
        return version8;
    }

    public void setVersion8(String version8) {
        this.version8 = version8;
    }
}
