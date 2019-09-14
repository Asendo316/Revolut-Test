package com.cordiscorp.revolut.connectivity.models;

import java.util.Observable;

/**
 * Created by Ibkunle Adeoluwa on 9/13/2019.
 */
public class ConversionModel extends Observable {
    String amount ;

    public ConversionModel(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ConversionModel{" +
                "amount='" + amount + '\'' +
                '}';
    }
}
