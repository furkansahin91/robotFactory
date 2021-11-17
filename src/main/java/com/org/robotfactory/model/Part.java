package com.org.robotfactory.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Part implements Serializable {
    public String name;
    public BigDecimal price;
    public int stock;
    public String code;

    public Part() {
    }

    public Part(String name, BigDecimal price, int stock, String code) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
