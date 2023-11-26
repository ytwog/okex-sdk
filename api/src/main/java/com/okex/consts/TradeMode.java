package com.okex.consts;

public enum TradeMode {
    CASH("cash"),
    CROSS("cross"),
    ISOLATED("isolated");

    public final String value;

    TradeMode(String value) {
        this.value = value;
    }
}
