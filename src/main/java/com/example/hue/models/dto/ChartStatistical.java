package com.example.hue.models.dto;

public class ChartStatistical {
    private String name;
    private int uses;
    private double performance;

    public ChartStatistical(String name, int uses, double performance) {
        this.name = name;
        this.uses = uses;
        this.performance = performance;
    }

    public ChartStatistical(String name, double performance) {
        this.name = name;
        this.performance = performance;
    }

    public ChartStatistical(String name, int uses) {
        this.name = name;
        this.uses = uses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
}
