package com.okex.consts;

public enum OkexApiVersion {
    V5(5, "/api/v5");

    public final int version;
    public final String path;

    OkexApiVersion(int version, String path) {
        this.version = version;
        this.path = path;
    }
}
