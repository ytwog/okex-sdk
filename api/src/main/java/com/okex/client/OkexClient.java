package com.okex.client;

import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.okex.consts.HttpMethod;
import com.okex.consts.OkexConstants;
import com.okex.consts.OkexEndpoint;
import com.okex.exception.OkexApiException;
import com.okex.model.OkexResponse;
import com.okex.utils.OkexRequestUtils;
import lombok.extern.log4j.Log4j2;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Log4j2
public class OkexClient {
    private static final boolean USE_SIMULATED_TRADING = false;
    private final Optional<Authorization> authorization;
    private final Gson gson;
    private OkHttpClient httpClient;

    public OkexClient(Optional<Authorization> authorization) {
        this.authorization = authorization;
        this.gson = new Gson();
        this.httpClient = new OkHttpClient.Builder().build();
    }

    public void updateWithProxyBySystemProperties() {
        Properties systemProperties = System.getProperties();
        updateWithProxy(
                systemProperties.getProperty("https.proxyHost"),
                systemProperties.getProperty("https.proxyPort"),
                Authenticator.JAVA_NET_AUTHENTICATOR
        );
    }

    public void updateWithProxyBySettings(ProxySettings proxySettings) {
        String credential = Credentials.basic(proxySettings.getLogin(), proxySettings.getPassword());
        Authenticator proxyAuthenticator = (route, response) -> response.request().newBuilder()
                .header("Proxy-Authorization", credential)
                .build();
        updateWithProxy(
                proxySettings.getIp(),
                proxySettings.getPort(),
                proxyAuthenticator
        );
    }

    public void updateWithProxy(String ip, String port, Authenticator proxyAuthenticator) {
        httpClient = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, Integer.parseInt(port))))
                .proxyAuthenticator(proxyAuthenticator)
                .build();
    }

    public <T> T execute(OkexEndpoint okexEndpoint, Map<String, String> params) throws Exception {
        try (Response response = sendRequest(okexEndpoint, params)) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            log.info("For url={} and params={} got responseBody={}", okexEndpoint.path, params, responseBody);
            if (!response.isSuccessful()) {
                throw new OkexApiException(String.format("Request failed. Code: %d, message: %s, body: %s",
                        response.code(), response.message(), responseBody));
            }
            Type type = TypeToken.getParameterized(OkexResponse.class, okexEndpoint.responseType).getType();
            OkexResponse<T> okexResponse = gson.fromJson(responseBody, type);
            validateNoErrors(okexEndpoint.path, params, okexResponse);
            return okexResponse.getData();
        }
    }

    private Response sendRequest(OkexEndpoint endpoint, Map<String, String> params) throws Exception {
        return endpoint.accessType.isPrivate
                ? sendPrivateRequest(endpoint, params)
                : sendPublicGetRequest(endpoint.path, params);
    }

    private Response sendPublicGetRequest(String requestUrl, Map<String, String> params) throws Exception {
        String queryString = OkexRequestUtils.generateQueryString(params).toString();
        log.info("Sending public request for uri={}?{}", requestUrl, queryString);
        Request.Builder builder = new Request.Builder()
                .url(String.format("%s%s?%s", OkexConstants.API_URL, requestUrl, queryString))
                .addHeader("Content-Type", "application/json");
        Request request = builder.get().build();
        Call call = httpClient.newCall(request);
        return call.execute();
    }

    private Response sendPrivateRequest(OkexEndpoint endpoint, Map<String, String> params) throws Exception {
        Request request = switch (endpoint.method) {
            case GET -> preparePrivateGetRequest(endpoint.path, params);
            case POST -> preparePrivatePostRequest(endpoint.path, params);
        };
        return httpClient.newCall(request).execute();
    }

    private Request preparePrivateGetRequest(String url, Map<String, String> params) throws Exception {
        Authorization auth = authorization.orElseThrow(() -> new IllegalArgumentException("Authorization data is empty"));
        String query = OkexRequestUtils.generateQueryString(params).toString();
        log.info("Sending private GET request for uri={}?{}", url, query);

        String ts = OkexRequestUtils.getTimeUTC();

        String signature = OkexRequestUtils.signGetRequest(auth.getSecretKey(), HttpMethod.GET + url, ts, query);
        Request.Builder requestBuilder = new Request.Builder()
                .url(String.format("%s%s?%s", OkexConstants.API_URL, url, query))
                .addHeader("OK-ACCESS-KEY", auth.getApiKey())
                .addHeader("OK-ACCESS-SIGN", signature)
                .addHeader("OK-ACCESS-TIMESTAMP", ts)
                .addHeader("OK-ACCESS-PASSPHRASE", auth.getPassphrase())
                .addHeader("Content-Type", "application/json");

        return requestBuilder.get().build();
    }

    private Request preparePrivatePostRequest(String url, Map<String, String> params) throws Exception {
        Authorization auth = authorization.orElseThrow(() -> new IllegalArgumentException("Authorization data is empty"));
        String paramJson = gson.toJson(params);
        log.info("Sending private POST request for uri={}, body:{}", url, paramJson);

        String ts = OkexRequestUtils.getTimeUTC();
        String signature = OkexRequestUtils.signPostRequest(auth.getSecretKey(), HttpMethod.POST + url, ts, paramJson);
        Request.Builder requestBuilder = new Request.Builder()
                .url(String.format("%s%s", OkexConstants.API_URL, url))
                .addHeader("OK-ACCESS-KEY", auth.getApiKey())
                .addHeader("OK-ACCESS-SIGN", signature)
                .addHeader("OK-ACCESS-TIMESTAMP", ts)
                .addHeader("OK-ACCESS-PASSPHRASE", auth.getPassphrase())
                .addHeader("Content-Type", "application/json");

        if (USE_SIMULATED_TRADING) {
            requestBuilder.addHeader("x-simulated-trading", "1");
        }
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(paramJson, mediaType);
        return requestBuilder.post(body).build();
    }

    private <T> void validateNoErrors(String requestUrl, Map<String, String> params, OkexResponse<T> okexResponse) throws OkexApiException {
        if (okexResponse.getCode() == 0) {
            return;
        }
        throw new OkexApiException(String.format("For url=%s and params=%s got error and response: %s",
                requestUrl, params, okexResponse));
    }
}
