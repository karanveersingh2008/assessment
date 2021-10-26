package com.assessment.assessment.entity;

public class SupplyDemandRequestResponse {
private String Productid;
private Double availableQuantity;

    public SupplyDemandRequestResponse(String productid, Double availableQuantity) {
        super();
        this.Productid = productid;
        this.availableQuantity = availableQuantity;
    }

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String productid) {
        Productid = productid;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "SupplyDemandRequestResponse{" +
                "Productid='" + Productid + '\'' +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
