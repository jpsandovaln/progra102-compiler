package com.jalasoft.compiler.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class CommandException extends Exception {
    private static final String MESSAGE = "Malformed command.";

    public CommandException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public CommandException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public CommandException(String currentMessage) {
        super(currentMessage);
    }

    public CommandException() {
        super(MESSAGE);
    }
}
