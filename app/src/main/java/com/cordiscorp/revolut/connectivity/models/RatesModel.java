package com.cordiscorp.revolut.connectivity.models;

/**
 * Created by Ibkunle Adeoluwa on 9/11/2019.
 */
public class RatesModel {
    String name;
    String amount;

    public RatesModel(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RatesModel{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
