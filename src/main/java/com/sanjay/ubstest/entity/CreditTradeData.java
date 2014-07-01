package com.sanjay.ubstest.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Hold the trade data for each credit ratings.
 */
public class CreditTradeData {
    private final String credit;
    private final List<Double> amounts = new ArrayList<Double>();

    public CreditTradeData(final String credit) {
        this.credit = credit;
    }
    public void add(final Double amount) {
        amounts.add(amount);
    }

    /**
     * if prices are not available then average will return as -1;
     * @return
     */
    public Double getAverage(){
        Double average = -1.0;
        Double total = 0.0;
        for ( Double amount : amounts){
            total += amount;
        }
        if ( amounts.size()>0){
            average = total/amounts.size();
        }
        return  average;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for ( Double amount : amounts){
            sb.append(String.format("\t\t%s\t%10.2f\n",credit,amount));
        }
        sb.append(String.format("=======================================\nRating[%s] Avg: Euro %.2f\n", credit, getAverage()));
        return sb.toString();

    }

    public static void main(String[] args) {
        CreditTradeData d = new CreditTradeData("aaa");
        d.add(1.0);
        d.add(2.0);
        d.add(3.0);
        System.out.println(d.toString());
    }

}
