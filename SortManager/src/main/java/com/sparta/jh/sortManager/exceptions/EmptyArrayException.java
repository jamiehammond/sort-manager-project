package com.sparta.jh.sortManager.exceptions;

/**
 * Exception thrown when an array is empty.
 */
public class EmptyArrayException extends Exception {
    @Override
    public String getMessage() {
        return "Array cannot be empty!";
    }
}