package com.dpwallet.core.exchange.shapeshift.data;

import com.dpwallet.core.coins.CoinID;
import com.dpwallet.core.coins.CoinType;
import com.dpwallet.core.util.ExchangeRate;
import com.dpwallet.core.util.ExchangeRateBase;

import org.json.JSONObject;

import static com.dpwallet.core.Preconditions.checkState;

/**
 * @author John L. Jegutanis
 */
public class ShapeShiftRate extends ShapeShiftPairBase {
    public final ExchangeRate rate;

    public ShapeShiftRate(JSONObject data) throws ShapeShiftException {
        super(data);
        if (!isError) {
            try {
                String[] pairs = pair.split("_");
                checkState(pairs.length == 2);
                CoinType typeFrom = CoinID.typeFromSymbol(pairs[0]);
                CoinType typeTo = CoinID.typeFromSymbol(pairs[1]);
                rate = new ShapeShiftExchangeRate(typeFrom, typeTo,
                        data.getString("rate"), data.optString("minerFee", null));
            } catch (Exception e) {
                throw new ShapeShiftException("Could not parse object", e);
            }
        } else {
            rate = null;
        }
    }
}
