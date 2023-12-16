package com.okex.client;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.okex.consts.InstType;
import com.okex.consts.OkexEndpoint;
import com.okex.consts.OrderSide;
import com.okex.consts.OrderType;
import com.okex.consts.TradeMode;
import com.okex.consts.WithdrawalMethod;
import com.okex.model.AccountBalance;
import com.okex.model.AssetBalance;
import com.okex.model.AssetCurrency;
import com.okex.model.DepositAddress;
import com.okex.model.OrderBook;
import com.okex.model.OrderDetails;
import com.okex.model.Ticker;
import com.okex.model.Instrument;
import com.okex.model.PlaceOrderResult;
import com.okex.model.WithdrawResult;
import com.okex.utils.OkexRequestUtils;

public class OkexApi {
    private final OkexClient okexClient;

    public OkexApi(OkexClient okexClient) {
        this.okexClient = okexClient;
    }

    public static OkexApi newInstance(
            Optional<Authorization> authorization,
            Optional<ProxySettings> proxySettingsO,
            boolean useProxy)
    {
        OkexClient okexClient = new OkexClient(authorization);
        if (proxySettingsO.isPresent()) {
            okexClient.updateWithProxyBySettings(proxySettingsO.get());
        } else if (useProxy) {
            okexClient.updateWithProxyBySystemProperties();
        }
        return new OkexApi(okexClient);
    }

    public List<Instrument> getInstruments(
            InstType instType,
            Optional<String> instFamilyO,
            Optional<String> instIdO) throws Exception
    {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("instType", instType.name());
        instIdO.ifPresent(instId -> parameters.put("instId", instId));
        instFamilyO.ifPresent(instFamily -> parameters.put("instFamily", instFamily));
        return okexClient.execute(OkexEndpoint.INSTRUMENTS, parameters);
    }

    public Ticker getIndexTickers(String instId) throws Exception {
        Map<String, String> parameters = Map.of(
                "instId", instId
        );
        List<Ticker> tickers = okexClient.execute(OkexEndpoint.INDEX_TICKERS, parameters);
        return OkexRequestUtils.findFirstOrThrow(tickers, "getIndexTickers");
    }

    public List<Ticker> getTickers(InstType instType) throws Exception {
        Map<String, String> parameters = Map.of(
                "instType", instType.name()
        );
        return okexClient.execute(OkexEndpoint.TICKERS, parameters);
    }

    public List<Ticker> getTicker(String instId) throws Exception {
        Map<String, String> parameters = Map.of(
                "instId", instId
        );
        return okexClient.execute(OkexEndpoint.TICKER, parameters);
    }

    public OrderBook getOrderBook(String instId, int depthSize) throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("instId", instId);
        parameters.put("sz", String.valueOf(depthSize));
        List<OrderBook> orderBooks = okexClient.execute(OkexEndpoint.ORDER_BOOK, parameters);
        return OkexRequestUtils.findFirstOrThrow(orderBooks, "getOrderBook");
    }

    // Retrieve order top 25 book of the instrument more quickly
    public OrderBook getOrderLiteBook(String instId) throws Exception {
        Map<String, String> parameters = Map.of(
                "instId", instId
        );
        List<OrderBook> orderBooks = okexClient.execute(OkexEndpoint.ORDER_LITE_BOOK, parameters);
        return OkexRequestUtils.findFirstOrThrow(orderBooks, "getOrderLiteBook");
    }

    public List<AccountBalance> getAccountBalance(Optional<String> ccy) throws Exception {
        Map<String, String> parameters = new HashMap<>();
        ccy.ifPresent(value -> parameters.put("ccy", value));
        return okexClient.execute(OkexEndpoint.ACCOUNT_BALANCE, parameters);
    }

    public List<AssetCurrency> getAssetCurrencies(Optional<String> ccy) throws Exception {
        Map<String, String> parameters = new HashMap<>();
        ccy.ifPresent(value -> parameters.put("ccy", value));
        return okexClient.execute(OkexEndpoint.ASSET_CURRENCIES, parameters);
    }

    public List<AssetBalance> getAssetBalances(Optional<String> ccy) throws Exception {
        Map<String, String> parameters = new HashMap<>();
        ccy.ifPresent(value -> parameters.put("ccy", value));
        return okexClient.execute(OkexEndpoint.ASSET_BALANCES, parameters);
    }

    public PlaceOrderResult placeOrder(
            String instId,
            TradeMode tdMode,
            OrderSide orderSide,
            OrderType orderType,
            BigDecimal sz) throws Exception
    {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("instId", instId);
        parameters.put("tdMode", tdMode.value);
        parameters.put("side", orderSide.value);
        parameters.put("ordType", orderType.value);
        parameters.put("sz", sz.toString());
        return OkexRequestUtils.findFirstOrThrow(okexClient.execute(OkexEndpoint.PLACE_ORDER, parameters), "place order");
    }

    public List<OrderDetails> getOrderDetails(String instId, String ordId) throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("instId", instId);
        parameters.put("ordId", ordId);
        return okexClient.execute(OkexEndpoint.ORDER_DETAILS, parameters);
    }

    public List<WithdrawResult> withdraw(
            String ccy,
            BigDecimal amount,
            WithdrawalMethod dest,
            String toAddr,
            String chain,
            String fee) throws Exception
    {
        Map<String, String> parameters = Map.of(
                "ccy", ccy,
                "amt", amount.toString(),
                "dest", dest.id,
                "toAddr", toAddr,
                "chain", chain,
                "fee", fee
        );
        return okexClient.execute(OkexEndpoint.WITHDRAW, parameters);
    }

    public List<DepositAddress> getDepositAddresses(
            String ccy) throws Exception
    {
        Map<String, String> parameters = Map.of(
                "ccy", ccy
        );
        return okexClient.execute(OkexEndpoint.DEPOSIT_ADDRESS, parameters);
    }
}