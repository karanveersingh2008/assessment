package com.assessment.assessment.entity;

public class Demand {
    private String productId;
    private int quantity;

    public Demand(String productId, int quantity) {
        super();
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
