package com.okex.model;

/**
 * @author ytwog
 */
public class WithdrawResult {
    private final String ccy;
    private final String chain;
    private final String amt;
    private final String wdId;
    private final String clientId;

    public WithdrawResult(String ccy, String chain, String amt, String wdId, String clientId) {
        this.ccy = ccy;
        this.chain = chain;
        this.amt = amt;
        this.wdId = wdId;
        this.clientId = clientId;
    }

    public String getCcy() {
        return ccy;
    }

    public String getChain() {
        return chain;
    }

    public String getAmt() {
        return amt;
    }

    public String getWdId() {
        return wdId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "WithdrawResult{" +
                "ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", amt='" + amt + '\'' +
                ", wdId='" + wdId + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
