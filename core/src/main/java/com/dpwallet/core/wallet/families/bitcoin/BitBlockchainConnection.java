package com.dpwallet.core.wallet.families.bitcoin;

import com.dpwallet.core.network.AddressStatus;
import com.dpwallet.core.network.interfaces.BlockchainConnection;

/**
 * @author John L. Jegutanis
 */
public interface BitBlockchainConnection extends BlockchainConnection<BitTransaction> {
    void getUnspentTx(AddressStatus status, BitTransactionEventListener listener);
}
