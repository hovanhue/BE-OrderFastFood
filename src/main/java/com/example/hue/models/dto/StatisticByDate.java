package com.example.hue.models.dto;

public class StatisticByDate {
    private String amount;
    private String dateOrdered;

    public StatisticByDate() {
    }

    public StatisticByDate(String amount, String dateOrdered) {
        this.amount = amount;
        this.dateOrdered = dateOrdered;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
}
