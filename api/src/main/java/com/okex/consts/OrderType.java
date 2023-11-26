package com.okex.consts;

public enum OrderType {
    MARKET("market"),
    LIMIT("limit");

    public final String value;

    OrderType(String value) {
        this.value = value;
    }
}
