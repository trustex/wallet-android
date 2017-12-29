package com.mycelium.wapi.wallet.bip44;

import com.mrd.bitlib.model.NetworkParameters;
import com.mycelium.wapi.api.Wapi;
import com.mycelium.wapi.model.TransactionSummary;
import com.mycelium.wapi.wallet.Bip44AccountBacking;
import com.mycelium.wapi.wallet.SpvBalanceFetcher;
import com.mycelium.wapi.wallet.currency.CurrencyBasedBalance;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Bip44BCHAccount extends Bip44Account {

    private SpvBalanceFetcher spvBalanceFetcher;

    public Bip44BCHAccount(Bip44AccountContext context, Bip44AccountKeyManager keyManager, NetworkParameters network, Bip44AccountBacking backing, Wapi wapi, SpvBalanceFetcher spvBalanceFetcher) {
        super(context, keyManager, network, backing, wapi);
        this.spvBalanceFetcher = spvBalanceFetcher;
        this.type = Type.BCHBIP44;
    }

    @Override
    public CurrencyBasedBalance getCurrencyBasedBalance() {
        return spvBalanceFetcher.retrieveByHdAccountIndex(getId().toString(), getAccountIndex());
    }

    @Override
    public UUID getId() {
        return UUID.nameUUIDFromBytes(("BCH" + super.getId().toString()).getBytes());
    }

    @Override
    public List<TransactionSummary> getTransactionHistory(int offset, int limit) {
        return Collections.emptyList();
    }

    @Override
    public List<TransactionSummary> getTransactionsSince(Long receivingSince) {
        return Collections.emptyList();
    }

}