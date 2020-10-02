package com.jalasoft.compiler.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author HP
 * @version 1.1
 */
class PropertyHandler {
    private static PropertyHandler propertyHandler;
    private static Properties properties;
    private final static String CONFIG_FILE = "configuration.properties";
    private final static  String SEPARATOR = ",";

    private PropertyHandler(){
        try {
            this.properties = new Properties();
            this.properties.load(getClass().getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static PropertyHandler getInstance(){
        if(propertyHandler == null) {
            propertyHandler = new PropertyHandler();
        }
        return propertyHandler;
    }

    public String getValueAsString(String key) {
        return properties.getProperty(key);
    }

    public List<String> getValueAsList(String key) {
        String value = this.getValueAsString(key);
        return new ArrayList<>(
                Arrays.asList(value.split(SEPARATOR))
        );
    }
}
