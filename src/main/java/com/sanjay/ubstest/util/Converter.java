package com.sanjay.ubstest.util;

/**
 * Created by chickpick on 29/06/14.
 */

/**
 * Interface to convert one object to another object.
 * @param <In> Input Object
 * @param <Out> convert the output object.
 */
public interface Converter<In, Out>{
    Out convert(In input) throws ConverterException;
}
