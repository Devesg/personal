package com.personal.project.exception;

public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException() {
        super();
    }
    
    public DuplicateMemberException(String message) {
        super(message);
    }
}