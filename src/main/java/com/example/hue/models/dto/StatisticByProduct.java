package com.example.hue.models.dto;

public class StatisticByProduct {
    private String idCategory;
    private String idProduct;
    private String month;

    public StatisticByProduct() {
    }

    public StatisticByProduct(String idCategory, String idProduct, String month) {
        this.idCategory = idCategory;
        this.idProduct = idProduct;
        this.month = month;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
