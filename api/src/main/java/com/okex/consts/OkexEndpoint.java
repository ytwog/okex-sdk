package com.okex.consts;

import java.lang.reflect.Type;

public enum OkexEndpoint {
    // PUBLIC
    INSTRUMENTS(OkexApiVersion.V5, OkexEndpointType.PUBLIC, "/instruments", HttpMethod.GET, TypeConsts.INSTRUMENT_LIST_TYPE),
    INDEX_TICKERS(OkexApiVersion.V5, OkexEndpointType.MARKET, "/index-tickers", HttpMethod.GET, TypeConsts.TICKERS_LIST_TYPE),
    TICKERS(OkexApiVersion.V5, OkexEndpointType.MARKET, "/tickers", HttpMethod.GET, TypeConsts.TICKERS_LIST_TYPE),
    TICKER(OkexApiVersion.V5, OkexEndpointType.MARKET, "/ticker", HttpMethod.GET, TypeConsts.TICKERS_LIST_TYPE),
    ORDER_BOOK(OkexApiVersion.V5, OkexEndpointType.MARKET, "/books", HttpMethod.GET, TypeConsts.ORDER_BOOK_LIST_TYPE),
    ORDER_LITE_BOOK(OkexApiVersion.V5, OkexEndpointType.MARKET, "/books-lite", HttpMethod.GET, TypeConsts.ORDER_BOOK_LIST_TYPE),
    // PRIVATE
    ACCOUNT_BALANCE(OkexApiVersion.V5, OkexEndpointType.ACCOUNT, "/balance", HttpMethod.GET, TypeConsts.ACCOUNT_BALANCE_LIST_TYPE),
    ASSET_CURRENCIES(OkexApiVersion.V5, OkexEndpointType.ASSET, "/currencies", HttpMethod.GET, TypeConsts.ASSET_CURRENCIES_LIST_TYPE),
    ASSET_BALANCES(OkexApiVersion.V5, OkexEndpointType.ASSET, "/balances", HttpMethod.GET, TypeConsts.ASSET_BALANCES_LIST_TYPE),
    DEPOSIT_ADDRESS(OkexApiVersion.V5, OkexEndpointType.ASSET, "/deposit-address", HttpMethod.GET, TypeConsts.DEPOSIT_ADDRESS_LIST_TYPE),
    WITHDRAW(OkexApiVersion.V5, OkexEndpointType.ASSET, "/withdrawal", HttpMethod.POST, TypeConsts.WITHDRAW_LIST_TYPE),
    PLACE_ORDER(OkexApiVersion.V5, OkexEndpointType.TRADE, "/order", HttpMethod.POST, TypeConsts.PLACE_ORDER_TYPE),
    ORDER_DETAILS(OkexApiVersion.V5, OkexEndpointType.TRADE, "/order", HttpMethod.GET, TypeConsts.ORDER_DETAILS_LIST_TYPE),
    ;

    public final OkexApiVersion apiVersion;
    public final OkexEndpointType accessType;
    public final String endpointPathSuffix;
    public final HttpMethod method;
    public final String path;
    public final Type responseType;

    OkexEndpoint(
            OkexApiVersion apiVersion,
            OkexEndpointType accessType,
            String endpointPathSuffix,
            HttpMethod method,
            Type responseType)
    {
        this.apiVersion = apiVersion;
        this.accessType = accessType;
        this.endpointPathSuffix = endpointPathSuffix;
        this.method = method;
        this.path = apiVersion.path + accessType.path + endpointPathSuffix;
        this.responseType = responseType;
    }
}
