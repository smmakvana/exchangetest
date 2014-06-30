package com.sanjay.ubstest.impl.convertor;

/**
 * An Exception class to indicate that object cannot be exchange into other object.
 */
public class ConverterException extends Exception {

    public ConverterException(String message, Throwable throwable) {
        super(message,throwable);
    }
}
