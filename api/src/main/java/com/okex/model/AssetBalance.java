package com.okex.model;

/**
 * @author ytwog
 */
public class AssetBalance {
    private final String frozenBal;
    private final String bal;
    private final String ccy;
    private final String availBal;

    public AssetBalance(String availBal, String frozenBal, String bal, String ccy) {
        this.availBal = availBal;
        this.frozenBal = frozenBal;
        this.bal = bal;
        this.ccy = ccy;
    }

    public String getFrozenBal() {
        return frozenBal;
    }

    public String getBal() {
        return bal;
    }

    public String getCcy() {
        return ccy;
    }

    public String getAvailBal() {
        return availBal;
    }

    @Override
    public String toString() {
        return "AssetBalances{" +
                "frozenBal='" + frozenBal + '\'' +
                ", bal='" + bal + '\'' +
                ", ccy='" + ccy + '\'' +
                ", availBal='" + availBal + '\'' +
                '}';
    }
}
