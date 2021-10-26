package com.assessment.assessment.entity;

import java.util.Date;

public class Capacity {

    private  String storeNo;
    private String productId;
    private  java.util.Date date;
    private  Double noOfOrdersAccepted;

    public Capacity(String storeNo,String productId, Date date, Double noOfOrdersAccepted) {
        this.storeNo = storeNo;
        this.productId = productId;
        this.date = date;
        this.noOfOrdersAccepted = noOfOrdersAccepted;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getNoOfOrdersAccepted() {
        return noOfOrdersAccepted;
    }

    public void setNoOfOrdersAccepted(Double noOfOrdersAccepted) {
        this.noOfOrdersAccepted = noOfOrdersAccepted;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "storeNo='" + storeNo + '\'' +
                ", productId='" + productId + '\'' +
                ", date=" + date +
                ", noOfOrdersAccepted=" + noOfOrdersAccepted +
                '}';
    }
}
