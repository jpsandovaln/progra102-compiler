package com.jalasoft.compiler.model.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HP
 * @version 1.1
 */
public class CommandFactory {
    private final static String JAVA="java";
    private final static String PYTHON="python";
    private final static Map<String, ICommandBuilder> COMMAND = new HashMap<String, ICommandBuilder>() {
        {
            put(JAVA, new JavaCommand());
            put(PYTHON, new PythonCommand());
        }
    };

    public static ICommandBuilder getCommand(String lang) {
       return COMMAND.get(lang);
    }
}
