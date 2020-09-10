package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.parameter.Parameter;

public interface ICommandBuilder {
    String buildCommand(Parameter parameter) throws CommandException;
}
