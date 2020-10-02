package com.jalasoft.compiler.common;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class ConfigurationProperty {
    public static List<String > getLanguages() {
        return PropertyHandler.getInstance().getValueAsList("execute.language");
    }

    public static String getOS() {
        return PropertyHandler.getInstance().getValueAsString("execute.operation-system");
    }

}
