package com.okex.model;

/**
 * @author ytwog
 */
public class TransferFundsResult {
    private final String transId;
    private final String clientId;
    private final String ccy;
    private final String from;
    private final String amt;
    private final String to;

    public TransferFundsResult(String transId, String clientId, String ccy, String from, String amt, String to) {
        this.transId = transId;
        this.clientId = clientId;
        this.ccy = ccy;
        this.from = from;
        this.amt = amt;
        this.to = to;
    }

    public String getTransId() {
        return transId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getCcy() {
        return ccy;
    }

    public String getFrom() {
        return from;
    }

    public String getAmt() {
        return amt;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "TransferFundsResult{" +
                "transId='" + transId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", ccy='" + ccy + '\'' +
                ", from='" + from + '\'' +
                ", amt='" + amt + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
