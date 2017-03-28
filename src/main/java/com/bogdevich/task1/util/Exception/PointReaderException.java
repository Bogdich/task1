package com.bogdevich.task1.util.Exception;

/**
 * Created by Adrienne on 22.03.17.
 */
public class PointReaderException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PointReaderException() {
    }

    public PointReaderException(String message) {
        super(message);
    }

    public PointReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointReaderException(Throwable cause) {
        super(cause);
    }
}
