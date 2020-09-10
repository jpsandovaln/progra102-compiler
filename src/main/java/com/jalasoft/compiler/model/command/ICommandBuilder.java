package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;

public interface ICommandBuilder {
    String buildCommand() throws CommandException;
}
