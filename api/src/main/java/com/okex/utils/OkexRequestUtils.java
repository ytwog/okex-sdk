package com.okex.utils;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.okex.exception.OkexApiException;

public class OkexRequestUtils {
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static String getTimeUTC() {
        return Instant.now().atOffset(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS).toString();
    }

    public static String signGetRequest(String secretKey, String endpoint, String ts, String query) throws Exception {
        String queryPatched = query.isBlank() ? "" : "?" + query;
        String preHash = ts + endpoint + queryPatched;
        return calculateHMAC(preHash, secretKey);
    }

    public static String signPostRequest(String secretKey, String endpoint, String ts, String body) throws Exception {
        String preHash = ts + endpoint + body;
        return calculateHMAC(preHash, secretKey);
    }

    private static String calculateHMAC(String preHash, String secretKey) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        return Base64.getEncoder().encodeToString(mac.doFinal(preHash.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Generate query string for GET requests
     */
    public static StringBuilder generateQueryString(Map<String, String> map) {
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            String key = iter.next();
            sb.append(key)
                    .append("=")
                    .append(map.get(key))
                    .append("&");
        }
        if (!sb.toString().equals("")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    private static String calculateHMAC(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        return Base64.getEncoder().encodeToString(mac.doFinal(data));
    }

    private static byte[] calculateSHA256(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(data.getBytes(StandardCharsets.UTF_8));
    }

    public static <T> T findFirstOrThrow(List<T> listResult, String operationName) throws OkexApiException {
        return listResult.stream()
                .findFirst()
                .orElseThrow(() -> new OkexApiException("Operation " + operationName + " returned empty result"));
    }
}