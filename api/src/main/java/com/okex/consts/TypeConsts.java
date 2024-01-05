package com.okex.consts;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.okex.model.AccountBalance;
import com.okex.model.AssetBalance;
import com.okex.model.AssetCurrency;
import com.okex.model.DepositAddress;
import com.okex.model.Instrument;
import com.okex.model.OrderBook;
import com.okex.model.OrderDetails;
import com.okex.model.PlaceOrderResult;
import com.okex.model.Ticker;
import com.okex.model.TransferFundsResult;
import com.okex.model.TransferFundsState;
import com.okex.model.WithdrawResult;

public class TypeConsts {
    public static final Type ACCOUNT_BALANCE_LIST_TYPE = TypeToken.getParameterized(List.class, AccountBalance.class).getType();
    public static final Type ASSET_BALANCES_LIST_TYPE = TypeToken.getParameterized(List.class, AssetBalance.class).getType();
    public static final Type WITHDRAW_LIST_TYPE = TypeToken.getParameterized(List.class, WithdrawResult.class).getType();
    public static final Type PLACE_ORDER_TYPE = TypeToken.getParameterized(List.class, PlaceOrderResult.class).getType();
    public static final Type ORDER_DETAILS_LIST_TYPE = TypeToken.getParameterized(List.class, OrderDetails.class).getType();
    public static final Type TRANSFER_FUNDS_LIST_TYPE = TypeToken.getParameterized(List.class, TransferFundsResult.class).getType();
    public static final Type TRANSFER_FUNDS_STATE_LIST_TYPE = TypeToken.getParameterized(List.class, TransferFundsState.class).getType();
    public static final Type ASSET_CURRENCIES_LIST_TYPE = TypeToken.getParameterized(List.class, AssetCurrency.class).getType();
    public static final Type INSTRUMENT_LIST_TYPE = TypeToken.getParameterized(List.class, Instrument.class).getType();
    public static final Type TICKERS_LIST_TYPE = TypeToken.getParameterized(List.class, Ticker.class).getType();
    public static final Type ORDER_BOOK_LIST_TYPE = TypeToken.getParameterized(List.class, OrderBook.class).getType();
    public static final Type DEPOSIT_ADDRESS_LIST_TYPE = TypeToken.getParameterized(List.class, DepositAddress.class).getType();
}