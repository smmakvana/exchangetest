package com.sanjay.ubstest.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chickpick on 01/07/14.
 */
public class GroupEuroData {

    private HashMap<String, HashMap<String,List<EuroData>>> countryGroup = new HashMap<String, HashMap<String, List<EuroData>>>();

    public HashMap<String, HashMap<String, List<EuroData>>> getCountryGroup() {
        return countryGroup;
    }

    public void printAvg() {

        Double ratingTotal = 0.0;
        Double countryTotal = 0.0;
        double N = 0;
        StringBuffer sb = new StringBuffer();


        for (String key: countryGroup.keySet()){
            countryTotal = 0.0;
            N=0;
            sb.append("Country " + key);
            sb.append("\n");
            HashMap<String, List<EuroData>> countryMap = countryGroup.get(key);
            for(String rating: countryMap.keySet()){
                List<EuroData> euroDataList = countryMap.get(rating);
                ratingTotal = 0.0;
                for(EuroData euroData : euroDataList){
                    ratingTotal += euroData.getAmount();
                    countryTotal+= euroData.getAmount();
                    N++;
                    sb.append(String.format("%s %s EUR:%10.2f\n",euroData.getCountry(), euroData.getRating(), euroData.getAmount()));

                }
                sb.append(String.format("Average for rating %s is ----->EUR:%10.2f\n",rating, (ratingTotal)/euroDataList.size()));
            }

            sb.append(String.format("Average for country %s is ----->EUR:%10.2f\n",key, (countryTotal)/N));
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}
