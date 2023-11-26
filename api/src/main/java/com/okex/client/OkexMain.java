package com.okex.client;

import java.util.Optional;

import com.okex.consts.OkexTestingSettings;

public class OkexMain {
    public static void main(String[] args) {
        OkexClient okexClient = new OkexClient(Optional.of(Authorization.newInstance(
                OkexTestingSettings.API_KEY,
                OkexTestingSettings.PRIVATE_KEY,
                OkexTestingSettings.PASSPHRASE)));
        OkexApi okexApi = new OkexApi(okexClient);
    }
}