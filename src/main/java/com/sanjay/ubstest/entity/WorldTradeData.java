package com.sanjay.ubstest.entity;
/*
 * Masabi Ltd.
 * 56 Ayres Street, London, SE1 1EU
 * http://www.masabi.com/
 *
 * Copyright (c) 2014 Masabi Ltd. All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

public class WorldTradeData {
    private Map<String, CountryTradeData> allTrade = new HashMap<String, CountryTradeData>();

    public void add(String countryOrCity,String rating, Double amount){
        CountryTradeData countryTradeData = allTrade.get(countryOrCity);
        if ( countryTradeData == null){
            countryTradeData = new CountryTradeData(countryOrCity);
            allTrade.put(countryOrCity,countryTradeData);
        }
        countryTradeData.add(rating, amount);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for ( CountryTradeData countryTradeData : allTrade.values()){
            sb.append(countryTradeData.toString());
            sb.append("**********************************************************************************\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WorldTradeData worldTradeData = new WorldTradeData();
        worldTradeData.add("UK","aa", 2.0);
        worldTradeData.add("UK","aa", 2.0);
        worldTradeData.add("UK","BB", 2.0);
        worldTradeData.add("UK","cc", 2.0);
        worldTradeData.add("UK","aa", 2.0);

        worldTradeData.add("India","aa", 2.0);
        worldTradeData.add("India","aa", 2.0);
        worldTradeData.add("India","BB", 2.0);
        worldTradeData.add("UK","cc", 2.0);
        worldTradeData.add("USA","aa", 2.0);

        System.out.println(worldTradeData.toString());
    }
}
