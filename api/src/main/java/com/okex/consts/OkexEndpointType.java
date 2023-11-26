package com.okex.consts;

public enum OkexEndpointType {
    PUBLIC("/public", false),
    MARKET("/market", false),
    ACCOUNT("/account", true),
    ASSET("/asset", true),
    TRADE("/trade", true),
    ;

    public final String path;
    public final boolean isPrivate;

    OkexEndpointType(String path, boolean isPrivate) {
        this.path = path;
        this.isPrivate = isPrivate;
    }
}
