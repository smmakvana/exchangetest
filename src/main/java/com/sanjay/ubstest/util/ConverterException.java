package com.sanjay.ubstest.util;

/**
 * An Exception class to indicate that object cannot be convert into other object.
 */
public class ConverterException extends Exception {

    public ConverterException(String message, Throwable throwable) {
        super(message,throwable);
    }
}
