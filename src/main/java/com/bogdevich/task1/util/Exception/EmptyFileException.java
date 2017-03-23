package com.bogdevich.task1.util.Exception;

/**
 * Created by Adrienne on 22.03.17.
 */
public class EmptyFileException extends PointReaderException{

    public EmptyFileException() {
        super();
    }

    public EmptyFileException(String message) {
        super(message);
    }

    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFileException(Throwable cause) {
        super(cause);
    }
}
