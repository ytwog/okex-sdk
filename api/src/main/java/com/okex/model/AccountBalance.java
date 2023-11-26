package com.okex.model;

import java.util.List;

/**
 * @author ytwog
 */
public class AccountBalance {
    private final String adjEq;
    private final String borrowFroz;
    private final List<BalanceDetails> details;

    public AccountBalance(String adjEq, String borrowFroz, List<BalanceDetails> details) {
        this.adjEq = adjEq;
        this.borrowFroz = borrowFroz;
        this.details = details;
    }

    public String getAdjEq() {
        return adjEq;
    }

    public String getBorrowFroz() {
        return borrowFroz;
    }

    public List<BalanceDetails> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "adjEq='" + adjEq + '\'' +
                ", borrowFroz='" + borrowFroz + '\'' +
                ", details=" + details +
                '}';
    }

    public static class BalanceDetails {
        private final String availBal;
        private final String availEq;
        private final String borrowFroz;
        private final String cashBal;
        private final String ccy;
        private final String crossLiab;
        private final String disEq;
        private final String eq;
        private final String eqUsd;
        private final String fixedBal;
        private final String frozenBal;
        private final String interest;
        private final String spotInUseAmt;
        private final String spotIsoBal;

        public BalanceDetails(
                String availBal,
                String availEq,
                String borrowFroz,
                String cashBal,
                String ccy,
                String crossLiab,
                String disEq,
                String eq,
                String eqUsd,
                String fixedBal,
                String frozenBal,
                String interest,
                String spotInUseAmt,
                String spotIsoBal)
        {
            this.availBal = availBal;
            this.availEq = availEq;
            this.borrowFroz = borrowFroz;
            this.cashBal = cashBal;
            this.ccy = ccy;
            this.crossLiab = crossLiab;
            this.disEq = disEq;
            this.eq = eq;
            this.eqUsd = eqUsd;
            this.fixedBal = fixedBal;
            this.frozenBal = frozenBal;
            this.interest = interest;
            this.spotInUseAmt = spotInUseAmt;
            this.spotIsoBal = spotIsoBal;
        }

        public String getAvailBal() {
            return availBal;
        }

        public String getAvailEq() {
            return availEq;
        }

        public String getBorrowFroz() {
            return borrowFroz;
        }

        public String getCashBal() {
            return cashBal;
        }

        public String getCcy() {
            return ccy;
        }

        public String getCrossLiab() {
            return crossLiab;
        }

        public String getDisEq() {
            return disEq;
        }

        public String getEq() {
            return eq;
        }

        public String getEqUsd() {
            return eqUsd;
        }

        public String getFixedBal() {
            return fixedBal;
        }

        public String getFrozenBal() {
            return frozenBal;
        }

        public String getInterest() {
            return interest;
        }

        public String getSpotInUseAmt() {
            return spotInUseAmt;
        }

        public String getSpotIsoBal() {
            return spotIsoBal;
        }

        @Override
        public String toString() {
            return "BalanceDetails{" +
                    "availBal='" + availBal + '\'' +
                    ", availEq='" + availEq + '\'' +
                    ", borrowFroz='" + borrowFroz + '\'' +
                    ", cashBal='" + cashBal + '\'' +
                    ", ccy='" + ccy + '\'' +
                    ", crossLiab='" + crossLiab + '\'' +
                    ", disEq='" + disEq + '\'' +
                    ", eq='" + eq + '\'' +
                    ", eqUsd='" + eqUsd + '\'' +
                    ", fixedBal='" + fixedBal + '\'' +
                    ", frozenBal='" + frozenBal + '\'' +
                    ", interest='" + interest + '\'' +
                    ", spotInUseAmt='" + spotInUseAmt + '\'' +
                    ", spotIsoBal='" + spotIsoBal + '\'' +
                    '}';
        }
    }
}
