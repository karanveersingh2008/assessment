package com.assessment.assessment.entity;


import java.time.LocalTime;
import java.util.Date;

public class Product {

    String productId;
    String productName;
    String unitOfMeasure;
    java.util.Date  launchDate;

    public Product() {}
    public Product(String productId, String productName, String unitOfMeasure,java.util.Date  launchDate) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        this.launchDate = launchDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", launchDate=" + launchDate +
                '}';
    }
}
