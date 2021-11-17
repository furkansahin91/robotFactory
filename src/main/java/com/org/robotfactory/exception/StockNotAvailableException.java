package com.org.robotfactory.exception;

public class StockNotAvailableException extends IllegalArgumentException{
    private String got;
    private String field;

    public StockNotAvailableException(String message, String got, String field) {
        super(message);
        this.got = got;
        this.field = field;
    }

    public String getGot() {
        return got;
    }

    public String getField() {
        return field;
    }
}
