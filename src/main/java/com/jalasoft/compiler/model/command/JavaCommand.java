package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;

/**
 * @author HP
 * @version 1.1
 */
public class JavaCommand implements ICommandBuilder {
    public String buildCommand() throws CommandException {

            String javaPath = "D:\\PROGRA102\\progra102-compiler\\thirdParty\\java\\jdk1.8.0_251\\bin\\";
            String javaFile = "D:\\PROGRA102\\HelloWorld.java";
            String classPath = "D:\\PROGRA102\\";
            String command = javaPath + "javac " + javaFile + " && " + javaPath + "java -cp " + classPath + " HelloWorld";
        if(command.equals("")) {
            throw  new CommandException();
        }
        return command;
    }
}
