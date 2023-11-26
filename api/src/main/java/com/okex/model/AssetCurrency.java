package com.okex.model;

/**
 * @author ytwog
 */
public class AssetCurrency {
    private final boolean canDep;
    private final boolean canInternal;
    private final boolean canWd;
    private final boolean mainNet;
    private final boolean needTag;
    private final String ccy;
    private final String chain;
    private final String depQuotaFixed;
    private final String depQuoteDailyLayer2;
    private final String maxFee;
    private final String maxFeeForCtAddr;
    private final String maxWd;
    private final String minDep;
    private final String minDepArrivalConfirm;
    private final String minFee;
    private final String minWd;
    private final String minWdUnlockConfirm;
    private final String name;
    private final String usedDepQuotaFixed;
    private final String usedWdQuota;
    private final String wdQuota;
    private final String wdTickSz;

    public AssetCurrency(
            boolean canDep,
            boolean canInternal,
            boolean canWd,
            boolean mainNet,
            boolean needTag,
            String ccy,
            String chain,
            String depQuotaFixed,
            String depQuoteDailyLayer2,
            String maxFee,
            String maxFeeForCtAddr,
            String maxWd,
            String minDep,
            String minDepArrivalConfirm,
            String minFee,
            String minWd,
            String minWdUnlockConfirm,
            String name,
            String usedDepQuotaFixed,
            String usedWdQuota,
            String wdQuota,
            String wdTickSz)
    {
        this.canDep = canDep;
        this.canInternal = canInternal;
        this.canWd = canWd;
        this.mainNet = mainNet;
        this.needTag = needTag;
        this.ccy = ccy;
        this.chain = chain;
        this.depQuotaFixed = depQuotaFixed;
        this.depQuoteDailyLayer2 = depQuoteDailyLayer2;
        this.maxFee = maxFee;
        this.maxFeeForCtAddr = maxFeeForCtAddr;
        this.maxWd = maxWd;
        this.minDep = minDep;
        this.minDepArrivalConfirm = minDepArrivalConfirm;
        this.minFee = minFee;
        this.minWd = minWd;
        this.minWdUnlockConfirm = minWdUnlockConfirm;
        this.name = name;
        this.usedDepQuotaFixed = usedDepQuotaFixed;
        this.usedWdQuota = usedWdQuota;
        this.wdQuota = wdQuota;
        this.wdTickSz = wdTickSz;
    }

    public boolean isCanDep() {
        return canDep;
    }

    public boolean isCanInternal() {
        return canInternal;
    }

    public boolean isCanWd() {
        return canWd;
    }

    public String getCcy() {
        return ccy;
    }

    public String getChain() {
        return chain;
    }

    @Override
    public String toString() {
        return "AccountCurrencies{" +
                "canDep=" + canDep +
                ", canInternal=" + canInternal +
                ", canWd=" + canWd +
                ", mainNet=" + mainNet +
                ", needTag=" + needTag +
                ", ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", depQuotaFixed='" + depQuotaFixed + '\'' +
                ", depQuoteDailyLayer2='" + depQuoteDailyLayer2 + '\'' +
                ", maxFee='" + maxFee + '\'' +
                ", maxFeeForCtAddr='" + maxFeeForCtAddr + '\'' +
                ", maxWd='" + maxWd + '\'' +
                ", minDep='" + minDep + '\'' +
                ", minDepArrivalConfirm='" + minDepArrivalConfirm + '\'' +
                ", minFee='" + minFee + '\'' +
                ", minWd='" + minWd + '\'' +
                ", minWdUnlockConfirm='" + minWdUnlockConfirm + '\'' +
                ", name='" + name + '\'' +
                ", usedDepQuotaFixed='" + usedDepQuotaFixed + '\'' +
                ", usedWdQuota='" + usedWdQuota + '\'' +
                ", wdQuota='" + wdQuota + '\'' +
                ", wdTickSz='" + wdTickSz + '\'' +
                '}';
    }
}
