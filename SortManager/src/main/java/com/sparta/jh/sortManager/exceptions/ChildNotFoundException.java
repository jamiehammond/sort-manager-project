package com.sparta.jh.sortManager.exceptions;

/**
 * Exception thrown when a left or right child of a Node is not found.
 */
public class ChildNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Child not found!";
    }
}
