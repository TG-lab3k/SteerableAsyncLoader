package com.steerableasyncloader;

/**
 * Created by tony on 2014/12/28.
 */
public class OperationCanceledException extends RuntimeException{
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String message) {
        super(message != null ? message : "The operation has been canceled.");
    }
}
