package com.okex.model;

/**
 * @author ytwog
 */
public class OrderDetails {
    private final String instType;
    private final String instId;
    private final String tgtCcy;
    private final String ccy;
    private final String ordId;
    private final String px;
    private final String ordType;
    private final String side;
    private final String posSide;
    private final String tdMode;
    private final String fee;
    private final String feeCcy;
    private final String fillPx;
    private final String fillSz;

    public OrderDetails(
            String instType,
            String instId,
            String tgtCcy,
            String ccy,
            String ordId,
            String px,
            String ordType,
            String side,
            String posSide,
            String tdMode,
            String fee,
            String feeCcy,
            String fillPx,
            String fillSz)
    {
        this.instType = instType;
        this.instId = instId;
        this.tgtCcy = tgtCcy;
        this.ccy = ccy;
        this.ordId = ordId;
        this.px = px;
        this.ordType = ordType;
        this.side = side;
        this.posSide = posSide;
        this.tdMode = tdMode;
        this.fee = fee;
        this.feeCcy = feeCcy;
        this.fillPx = fillPx;
        this.fillSz = fillSz;
    }

    public String getInstType() {
        return instType;
    }

    public String getInstId() {
        return instId;
    }

    public String getTgtCcy() {
        return tgtCcy;
    }

    public String getCcy() {
        return ccy;
    }

    public String getOrdId() {
        return ordId;
    }

    public String getPx() {
        return px;
    }

    public String getOrdType() {
        return ordType;
    }

    public String getSide() {
        return side;
    }

    public String getPosSide() {
        return posSide;
    }

    public String getTdMode() {
        return tdMode;
    }

    public String getFee() {
        return fee;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public String getFillPx() {
        return fillPx;
    }

    public String getFillSz() {
        return fillSz;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "instType='" + instType + '\'' +
                ", instId='" + instId + '\'' +
                ", tgtCcy='" + tgtCcy + '\'' +
                ", ccy='" + ccy + '\'' +
                ", ordId='" + ordId + '\'' +
                ", px='" + px + '\'' +
                ", ordType='" + ordType + '\'' +
                ", side='" + side + '\'' +
                ", posSide='" + posSide + '\'' +
                ", tdMode='" + tdMode + '\'' +
                ", fee='" + fee + '\'' +
                ", feeCcy='" + feeCcy + '\'' +
                ", fillPx='" + fillPx + '\'' +
                ", fillSz='" + fillSz + '\'' +
                '}';
    }
}
