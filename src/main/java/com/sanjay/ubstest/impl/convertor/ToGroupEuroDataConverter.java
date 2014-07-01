package com.sanjay.ubstest.impl.convertor;

import com.sanjay.ubstest.entity.EuroData;
import com.sanjay.ubstest.entity.GroupEuroData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chickpick on 01/07/14.
 */
public class ToGroupEuroDataConverter implements Converter<List<EuroData>,GroupEuroData> {
    @Override
    public GroupEuroData convert(List<EuroData> input) throws ConverterException {
        GroupEuroData groupEuroData = new GroupEuroData();

        for ( EuroData euroData : input){
            HashMap<String, List<EuroData>> countryMap = groupEuroData.getCountryGroup().get(euroData.getCountry());
            if(countryMap == null){
                countryMap = new HashMap<String, List<EuroData>>();
                groupEuroData.getCountryGroup().put(euroData.getCountry(),countryMap);
            }

            List<EuroData> list = countryMap.get(euroData.getRating().toLowerCase());
            if ( list == null){
                list = new ArrayList<EuroData>();
                countryMap.put(euroData.getRating().toLowerCase(),list);
            }
            list.add(euroData);
        }
        return groupEuroData;
    }


}
