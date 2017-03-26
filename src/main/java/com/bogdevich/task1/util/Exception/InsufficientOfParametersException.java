package com.bogdevich.task1.util.Exception;

/**
 * Created by Adrienne on 22.03.17.
 */
public class InsufficientOfParametersException extends RuntimeException {
    public InsufficientOfParametersException() {
        super();
    }

    public InsufficientOfParametersException(String message) {
        super(message);
    }

    public InsufficientOfParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientOfParametersException(Throwable cause) {
        super(cause);
    }
}
