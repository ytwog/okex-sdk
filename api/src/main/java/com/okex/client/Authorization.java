package com.okex.client;

public class Authorization {
    private final String apiKey;
    private final String secretKey;
    private final String passphrase;

    public Authorization(String apiKey, String secretKey, String passphrase) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.passphrase = passphrase;
    }

    public static Authorization newInstance(String apiKey, String secretKey, String passphrase) {
        return new Authorization(apiKey, secretKey, passphrase);
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getPassphrase() {
        return passphrase;
    }
}
