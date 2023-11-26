package com.okex.model;

/**
 * @author ytwog
 */
public class DepositAddress {
    private final String addr;
    private final String tag;
    private final String memo;
    private final String pmtId;
    private final String addrEx;
    private final String ccy;
    private final String chain;
    private final String to;
    private final String selected;
    private final String ctAddr;

    public DepositAddress(
            String addr,
            String tag,
            String memo,
            String pmtId,
            String addrEx,
            String ccy,
            String chain,
            String to,
            String selected,
            String ctAddr)
    {
        this.addr = addr;
        this.tag = tag;
        this.memo = memo;
        this.pmtId = pmtId;
        this.addrEx = addrEx;
        this.ccy = ccy;
        this.chain = chain;
        this.to = to;
        this.selected = selected;
        this.ctAddr = ctAddr;
    }

    public String getAddr() {
        return addr;
    }

    public String getTag() {
        return tag;
    }

    public String getMemo() {
        return memo;
    }

    public String getPmtId() {
        return pmtId;
    }

    public String getAddrEx() {
        return addrEx;
    }

    public String getCcy() {
        return ccy;
    }

    public String getChain() {
        return chain;
    }

    public String getTo() {
        return to;
    }

    public String getSelected() {
        return selected;
    }

    public String getCtAddr() {
        return ctAddr;
    }

    @Override
    public String toString() {
        return "DepositAddress{" +
                "addr='" + addr + '\'' +
                ", tag='" + tag + '\'' +
                ", memo='" + memo + '\'' +
                ", pmtId='" + pmtId + '\'' +
                ", addrEx='" + addrEx + '\'' +
                ", ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", to='" + to + '\'' +
                ", selected='" + selected + '\'' +
                ", ctAddr='" + ctAddr + '\'' +
                '}';
    }
}
