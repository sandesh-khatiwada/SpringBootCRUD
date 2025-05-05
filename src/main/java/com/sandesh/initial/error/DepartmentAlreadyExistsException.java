package com.sandesh.initial.error;

public class DepartmentAlreadyExistsException extends Exception{

    public DepartmentAlreadyExistsException() {
        super();
    }

    public DepartmentAlreadyExistsException(String message) {
        super(message);
    }

    public DepartmentAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected DepartmentAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
