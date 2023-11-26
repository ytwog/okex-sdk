package com.okex.model;

public enum WalletType {
    EXCHANGE("exchange"),
    PRIVATE("private"),
    ;

    public final String name;

    WalletType(String name) {
        this.name = name;
    }
}
