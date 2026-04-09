package kr.co.javaex.sec23.domain;

import java.util.List;

public class Cart {

    private String productId;
    private int quantity;

    public Cart() {
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
}