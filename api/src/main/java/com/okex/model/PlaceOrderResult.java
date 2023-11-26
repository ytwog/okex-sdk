package com.okex.model;

/**
 * @author ytwog
 */
public class PlaceOrderResult {
    private final String clOrdId;
    private final String ordId;
    private final String tag;
    private final String sCode;
    private final String sMsg;

    public PlaceOrderResult(String clOrdId, String ordId, String tag, String sCode, String sMsg) {
        this.clOrdId = clOrdId;
        this.ordId = ordId;
        this.tag = tag;
        this.sCode = sCode;
        this.sMsg = sMsg;
    }

    public String getClOrdId() {
        return clOrdId;
    }

    public String getOrdId() {
        return ordId;
    }

    public String getTag() {
        return tag;
    }

    public String getsCode() {
        return sCode;
    }

    public String getsMsg() {
        return sMsg;
    }

    @Override
    public String toString() {
        return "PlaceOrderResult{" +
                "clOrdId='" + clOrdId + '\'' +
                ", ordId='" + ordId + '\'' +
                ", tag='" + tag + '\'' +
                ", sCode='" + sCode + '\'' +
                ", sMsg='" + sMsg + '\'' +
                '}';
    }
}
