package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.parameter.Parameter;

public interface ICommandBuilder<T extends Parameter> {
    String buildCommand(T parameter) throws CommandException, InvalidDataException;
}
