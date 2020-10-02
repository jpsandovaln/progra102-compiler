package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class JavaCommandTest {

    public final static String javaFolder8 = "D:/PROGRA102/progra102-compiler/thirdParty/java/jdk1.8.0_251/bin/";
    public final static String javaFolder8Invalid = "D:/PROGRA102/progra102-compiler/thirdParty123/java/jdk1.8.0_251/bin/";

    public final static String javaFile = "src/test/resources/javaFolder/HelloWorld.java";
    public final static String javaFileInvalid = "src/test/resources/javaFolder/HelloWorld11.java";

    @Test
    public void buildCommand() throws CommandException, InvalidDataException {
        JavaParameter javaParameter = new JavaParameter(new File(javaFile),javaFolder8);
        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "D:/PROGRA102/progra102-compiler/thirdParty/java/jdk1.8.0_251/bin/javac D:\\PROGRA102\\progra102-compiler\\src\\test\\resources\\javaFolder\\HelloWorld.java && java -cp src\\test\\resources\\javaFolder HelloWorld";
        assertEquals("valid command", result, expected);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandNullParameter() throws CommandException, InvalidDataException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(null);
    }

    /*@Test
    public void buildCommandInvalidFolder() throws CommandException, InvalidDataException {
        JavaParameter javaParameter = new JavaParameter(new File(javaFile), javaFolder8Invalid);
        JavaCommand command = new JavaCommand();
        System.out.println(command.buildCommand(javaParameter));

    }*/

    @Test(expected = InvalidDataException.class)
    public void buildCommandJavaParameterInvalid() throws CommandException, InvalidDataException {
        JavaParameter javaParameter = new JavaParameter(null, null);
        JavaCommand command = new JavaCommand();
        command.buildCommand(javaParameter);
    }
}