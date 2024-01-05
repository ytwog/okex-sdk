package com.okex.client;

import java.math.BigDecimal;
import java.util.Optional;

import com.okex.consts.InstType;
import com.okex.consts.OkexTestingSettings;
import com.okex.consts.OrderSide;
import com.okex.consts.OrderType;
import com.okex.consts.TradeMode;
import com.okex.consts.TransferSide;
import com.okex.consts.WithdrawalMethod;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ytwog
 */
class OkexApiTest {
    private static OkexApi okexApi;

    @BeforeAll
    public static void setup() {
        OkexClient okexClient = new OkexClient(
                Optional.of(Authorization.newInstance(
                        OkexTestingSettings.API_KEY,
                        OkexTestingSettings.PRIVATE_KEY,
                        OkexTestingSettings.PASSPHRASE)
                )
        );
        okexApi = new OkexApi(okexClient);
    }

    @Test
    public void testInstruments() throws Exception {
        System.out.println(okexApi.getInstruments(
                InstType.SPOT,
                Optional.empty(),
                 Optional.of("BTC-USDT")
        ));
    }

    @Test
    public void testTickers() throws Exception {
        System.out.println(okexApi.getIndexTickers("BTC-USD"));
        System.out.println(okexApi.getTickers(InstType.SPOT));
        System.out.println(okexApi.getTicker("BTC-USDT"));
    }

    @Test
    public void testOrderBook() throws Exception {
        System.out.println(okexApi.getOrderBook("BTC-USDT", 3));
        System.out.println(okexApi.getOrderLiteBook("BTC-USDT"));
    }


    @Test
    public void testAccountBalance() throws Exception {
        System.out.println(okexApi.getAccountBalance(Optional.empty()));
    }

    @Test
    public void testAssetBalances() throws Exception {
        System.out.println(okexApi.getAssetBalances(Optional.empty()));
    }

    @Test
    public void testAssetCurrencies() throws Exception {
        System.out.println(okexApi.getAssetCurrencies(Optional.of("BTC,ETH")));
    }

    @Test
    public void testPlaceOrder() throws Exception {
        // buy
        System.out.println(okexApi.placeOrder(
                "BTC-USDT",
                TradeMode.CASH,
                OrderSide.BUY,
                OrderType.MARKET,
                BigDecimal.valueOf(1.0)
        ));
        // sell
        System.out.println(okexApi.placeOrder(
                "BTC-USDT",
                TradeMode.CASH,
                OrderSide.SELL,
                OrderType.MARKET,
                BigDecimal.valueOf(0.0005)
        ));
    }

    @Test
    public void testOrderDetails() throws Exception {
        System.out.println(okexApi.getOrderDetails("BTC-USDT", "655318894189965315"));
    }

    @Test
    public void testWithdraw() throws Exception {
        System.out.println(okexApi.withdraw(
                "USDT",
                BigDecimal.valueOf(0.05),
                WithdrawalMethod.ON_CHAIN,
                "addddddressss",
                "USDT-ERC20",
                "0")
        );
    }

    @Test
    public void testDepositAddresses() throws Exception {
        System.out.println(okexApi.getDepositAddresses("BTC"));
    }

    @Test
    public void testTransferFunds() throws Exception {
        System.out.println(okexApi.transferFunds("USDT", "1.5", TransferSide.TRADING.value, TransferSide.FUNDING.value));
    }

    @Test
    public void testTransferFundsState() throws Exception {
        System.out.println(okexApi.getTransferFundsState("708809840"));
    }
}