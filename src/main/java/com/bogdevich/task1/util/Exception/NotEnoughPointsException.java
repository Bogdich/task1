package com.bogdevich.task1.util.Exception;

/**
 * Created by Adrienne on 22.03.17.
 */
public class NotEnoughPointsException extends PointReaderException {
    public NotEnoughPointsException() {
        super();
    }

    public NotEnoughPointsException(String message) {
        super(message);
    }

    public NotEnoughPointsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPointsException(Throwable cause) {
        super(cause);
    }
}
