package com.jalasoft.compiler.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteException extends Exception {
    private static final String MESSAGE = "Error executing code.";

    public ExecuteException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public ExecuteException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public ExecuteException(String currentMessage) {
        super(currentMessage);
    }

    public ExecuteException() {
        super(MESSAGE);
    }
}
