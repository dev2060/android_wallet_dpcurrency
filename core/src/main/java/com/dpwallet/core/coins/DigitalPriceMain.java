package com.dpwallet.core.coins;

import com.dpwallet.core.coins.families.PeerFamily;

/**
 * Created by vitaligrabovski on 7/4/18.
 */

public class DigitalPriceMain extends PeerFamily {
    private DigitalPriceMain() {
        id = "digitalprice.main";

        addressHeader = 68;
        p2shHeader = 85;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 50;
        dumpedPrivateKeyHeader = 153;

        name = "DigitalPrice";
        symbol = "DP";
        uriScheme = "digitalprice";
        bip44Index = 1012;
        unitExponent = 8;
        feeValue = value(10000); // 0.0001 DP
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 DP
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("DigitalPrice Signed Message:\n");

    }

    private static DigitalPriceMain instance = new DigitalPriceMain();
    public static synchronized CoinType get() {
        return instance;
    }
}


