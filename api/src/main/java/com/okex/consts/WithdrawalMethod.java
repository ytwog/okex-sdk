package com.okex.consts;

public enum WithdrawalMethod {
    INTERNAL("3"),
    ON_CHAIN("4");

    public final String id;

    WithdrawalMethod(String id) {
        this.id = id;
    }
}
