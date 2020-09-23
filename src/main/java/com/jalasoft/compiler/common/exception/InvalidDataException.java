package com.jalasoft.compiler.common.exception;

/**
 * @author HP
 * @version 1.1
 */
public class InvalidDataException extends Exception {
    private static final String MESSAGE = "Invalid Data.";

    public InvalidDataException() {
        super(MESSAGE);
    }

    public InvalidDataException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public InvalidDataException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public InvalidDataException(String currentMessage) {
        super(currentMessage);
    }
}
