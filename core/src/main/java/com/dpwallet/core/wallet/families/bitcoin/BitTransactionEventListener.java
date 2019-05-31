package com.dpwallet.core.wallet.families.bitcoin;

import com.dpwallet.core.network.AddressStatus;
import com.dpwallet.core.network.ServerClient.UnspentTx;
import com.dpwallet.core.network.interfaces.TransactionEventListener;

import java.util.List;

/**
 * @author John L. Jegutanis
 */
public interface BitTransactionEventListener extends TransactionEventListener<BitTransaction> {
    void onUnspentTransactionUpdate(AddressStatus status, List<UnspentTx> UnspentTxes);
}
