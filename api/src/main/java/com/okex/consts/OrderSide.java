package com.okex.consts;

public enum OrderSide {
    BUY("buy"),
    SELL("sell");

    public final String value;

    OrderSide(String value) {
        this.value = value;
    }
}
