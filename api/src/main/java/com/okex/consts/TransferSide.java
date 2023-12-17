package com.okex.consts;

public enum TransferSide {
    FUNDING("6"),
    TRADING("18");

    public final String value;

    TransferSide(String value) {
        this.value = value;
    }
}
