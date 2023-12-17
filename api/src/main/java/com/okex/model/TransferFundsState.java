package com.okex.model;

/**
 * @author ytwog
 */
public class TransferFundsState {
    private final String type;
    private final String state;

    public TransferFundsState(String type, String state) {
        this.type = type;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "TransferFundsState{" +
                "type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
