package com.org.robotfactory.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    public String id;

    public List<String> parts;

    public BigDecimal totalPrice;

    public Order(String id, List<String> parts, BigDecimal totalPrice) {
        this.id = id;
        this.parts = parts;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
