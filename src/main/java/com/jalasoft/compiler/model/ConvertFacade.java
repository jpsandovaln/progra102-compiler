package com.jalasoft.compiler.model;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.command.CommandFactory;
import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ExecuteException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.result.Result;

/**
 * @author HP
 * @version 1.1
 */
public class ConvertFacade {
    public static Result compile(JavaParameter parameter, String lang) throws CommandException, InvalidDataException, ExecuteException {
        ICommandBuilder<JavaParameter> command = CommandFactory.getCommand(lang);
        String commandResult = command.buildCommand(parameter);
        Execute execute = new Execute();
        return execute.executeJava(commandResult);
    }

}
