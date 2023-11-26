package com.okex.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ytwog
 */
public class OrderBook {
    private final List<String[]> asks;
    private final List<String[]> bids;
    private final String ts;

    public OrderBook(List<String[]> asks, List<String[]> bids, String ts) {
        this.asks = asks;
        this.bids = bids;
        this.ts = ts;
    }

    public List<String[]> getAsks() {
        return asks;
    }

    public List<String[]> getBids() {
        return bids;
    }

    public String getTs() {
        return ts;
    }

    @Override
    public String toString() {
        String asks = this.asks.stream().map(Arrays::toString).collect(Collectors.joining(","));
        String bids = this.bids.stream().map(Arrays::toString).collect(Collectors.joining(","));
        return "OrderBook{" +
                "asks='" + asks + '\'' +
                ", bids='" + bids + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
