package com.okex.model;

/**
 * @author ytwog
 */
public class Instrument {
    private final String instType;
    private final String instId;
    private final String uly;
    private final String instFamily;
    private final String baseCcy;
    private final String quoteCcy;
    private final String settleCcy;
    private final String ctVal;
    private final String ctMult;
    private final String ctValCcy;
    private final String optType;
    private final String stk;
    private final String listTime;
    private final String expTime;
    private final String lever;
    private final String tickSz;
    private final String lotSz;
    private final String minSz;
    private final String ctType;
    private final String alias;
    private final String state;
    private final String maxLmtSz;
    private final String maxMktSz;
    private final String maxLmtAmt;
    private final String maxMktAmt;
    private final String maxTwapSz;
    private final String maxIcebergSz;
    private final String maxTriggerSz;
    private final String maxStopSz;

    public Instrument(
            String instType,
            String instId,
            String uly,
            String instFamily,
            String baseCcy,
            String quoteCcy,
            String settleCcy,
            String ctVal,
            String ctMult,
            String ctValCcy,
            String optType,
            String stk,
            String listTime,
            String expTime,
            String lever,
            String tickSz,
            String lotSz,
            String minSz,
            String ctType,
            String alias,
            String state,
            String maxLmtSz,
            String maxMktSz,
            String maxLmtAmt,
            String maxMktAmt,
            String maxTwapSz,
            String maxIcebergSz,
            String maxTriggerSz,
            String maxStopSz)
    {
        this.instType = instType;
        this.instId = instId;
        this.uly = uly;
        this.instFamily = instFamily;
        this.baseCcy = baseCcy;
        this.quoteCcy = quoteCcy;
        this.settleCcy = settleCcy;
        this.ctVal = ctVal;
        this.ctMult = ctMult;
        this.ctValCcy = ctValCcy;
        this.optType = optType;
        this.stk = stk;
        this.listTime = listTime;
        this.expTime = expTime;
        this.lever = lever;
        this.tickSz = tickSz;
        this.lotSz = lotSz;
        this.minSz = minSz;
        this.ctType = ctType;
        this.alias = alias;
        this.state = state;
        this.maxLmtSz = maxLmtSz;
        this.maxMktSz = maxMktSz;
        this.maxLmtAmt = maxLmtAmt;
        this.maxMktAmt = maxMktAmt;
        this.maxTwapSz = maxTwapSz;
        this.maxIcebergSz = maxIcebergSz;
        this.maxTriggerSz = maxTriggerSz;
        this.maxStopSz = maxStopSz;
    }

    public String getInstType() {
        return instType;
    }

    public String getInstId() {
        return instId;
    }

    public String getUly() {
        return uly;
    }

    public String getInstFamily() {
        return instFamily;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public String getQuoteCcy() {
        return quoteCcy;
    }

    public String getSettleCcy() {
        return settleCcy;
    }

    public String getCtVal() {
        return ctVal;
    }

    public String getCtMult() {
        return ctMult;
    }

    public String getCtValCcy() {
        return ctValCcy;
    }

    public String getOptType() {
        return optType;
    }

    public String getStk() {
        return stk;
    }

    public String getListTime() {
        return listTime;
    }

    public String getExpTime() {
        return expTime;
    }

    public String getLever() {
        return lever;
    }

    public String getTickSz() {
        return tickSz;
    }

    public String getLotSz() {
        return lotSz;
    }

    public String getMinSz() {
        return minSz;
    }

    public String getCtType() {
        return ctType;
    }

    public String getAlias() {
        return alias;
    }

    public String getState() {
        return state;
    }

    public String getMaxLmtSz() {
        return maxLmtSz;
    }

    public String getMaxMktSz() {
        return maxMktSz;
    }

    public String getMaxLmtAmt() {
        return maxLmtAmt;
    }

    public String getMaxMktAmt() {
        return maxMktAmt;
    }

    public String getMaxTwapSz() {
        return maxTwapSz;
    }

    public String getMaxIcebergSz() {
        return maxIcebergSz;
    }

    public String getMaxTriggerSz() {
        return maxTriggerSz;
    }

    public String getMaxStopSz() {
        return maxStopSz;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instType='" + instType + '\'' +
                ", instId='" + instId + '\'' +
                ", uly='" + uly + '\'' +
                ", instFamily='" + instFamily + '\'' +
                ", baseCcy='" + baseCcy + '\'' +
                ", quoteCcy='" + quoteCcy + '\'' +
                ", settleCcy='" + settleCcy + '\'' +
                ", ctVal='" + ctVal + '\'' +
                ", ctMult='" + ctMult + '\'' +
                ", ctValCcy='" + ctValCcy + '\'' +
                ", optType='" + optType + '\'' +
                ", stk='" + stk + '\'' +
                ", listTime='" + listTime + '\'' +
                ", expTime='" + expTime + '\'' +
                ", lever='" + lever + '\'' +
                ", tickSz='" + tickSz + '\'' +
                ", lotSz='" + lotSz + '\'' +
                ", minSz='" + minSz + '\'' +
                ", ctType='" + ctType + '\'' +
                ", alias='" + alias + '\'' +
                ", state='" + state + '\'' +
                ", maxLmtSz='" + maxLmtSz + '\'' +
                ", maxMktSz='" + maxMktSz + '\'' +
                ", maxLmtAmt='" + maxLmtAmt + '\'' +
                ", maxMktAmt='" + maxMktAmt + '\'' +
                ", maxTwapSz='" + maxTwapSz + '\'' +
                ", maxIcebergSz='" + maxIcebergSz + '\'' +
                ", maxTriggerSz='" + maxTriggerSz + '\'' +
                ", maxStopSz='" + maxStopSz + '\'' +
                '}';
    }
}
