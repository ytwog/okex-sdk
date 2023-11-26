package com.okex.model;

/**
 * @author ytwog
 */
public class Ticker {
    private final String instType;
    private final String instId;
    private final String idxPx;
    private final String high24h;
    private final String sodUtc0;
    private final String open24h;
    private final String low24h;
    private final String sodUtc8;
    private final String ts;

    public Ticker(
            String instType,
            String instId,
            String idxPx,
            String high24h,
            String sodUtc0,
            String open24h,
            String low24h,
            String sodUtc8,
            String ts)
    {
        this.instType = instType;
        this.instId = instId;
        this.idxPx = idxPx;
        this.high24h = high24h;
        this.sodUtc0 = sodUtc0;
        this.open24h = open24h;
        this.low24h = low24h;
        this.sodUtc8 = sodUtc8;
        this.ts = ts;
    }

    public String getInstType() {
        return instType;
    }

    public String getInstId() {
        return instId;
    }

    public String getIdxPx() {
        return idxPx;
    }

    public String getHigh24h() {
        return high24h;
    }

    public String getSodUtc0() {
        return sodUtc0;
    }

    public String getOpen24h() {
        return open24h;
    }

    public String getLow24h() {
        return low24h;
    }

    public String getSodUtc8() {
        return sodUtc8;
    }

    public String getTs() {
        return ts;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "instType='" + instType + '\'' +
                ", instId='" + instId + '\'' +
                ", idxPx='" + idxPx + '\'' +
                ", high24h='" + high24h + '\'' +
                ", sodUtc0='" + sodUtc0 + '\'' +
                ", open24h='" + open24h + '\'' +
                ", low24h='" + low24h + '\'' +
                ", sodUtc8='" + sodUtc8 + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
