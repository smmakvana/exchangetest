package com.sanjay.ubstest.impl.convertor;

import java.util.List;

/**
 * Created by chickpick on 29/06/14.
 * Interface to exchange one object to another object.
 * @param <In> Input Object
 * @param <Out> exchange the output object.
 */
public interface Converter<In, Out>{

    Out convert(In input) throws ConverterException;

    List<Out> convert(List<In> inputList)throws ConverterException;

}
