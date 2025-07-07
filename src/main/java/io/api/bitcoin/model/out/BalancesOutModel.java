package io.api.bitcoin.model.out;

public record BalancesOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* Balances from outputs that the wallet can sign */
        Mine mine,
        /* Watchonly balances (not present if wallet does not watch anything) */
        WatchOnly watchOnly,
        /* Hash and height of the block this information was generated on */
        LastProcessedBlock lastProcessedBlock
        //##############################################################################################################
) {
    public record Mine(
            //-------
            /* Trusted balance (outputs created by the wallet or confirmed outputs) */
            Double trusted,
            /* Untrusted pending balance (outputs created by others that are in the mempool) */
            Double untrustedPending,
            /* Balance from immature coinbase outputs */
            Double immature,
            /* (only present if avoid_reuse is set) balance from coins sent to addresses that were previously
            spent from (potentially privacy violating) */
            Double used
            //##########################################################################################################
    ) { }

    public record WatchOnly(
            //-------
            /* Trusted balance (outputs created by the wallet or confirmed outputs) */
            Double trusted,
            /* Untrusted pending balance (outputs created by others that are in the mempool) */
            Double untrustedPending,
            /* Balance from immature coinbase outputs */
            Double immature
            //##########################################################################################################
    ) { }

    public record LastProcessedBlock(
            //-------
            /* Hash of the block this information was generated on */
            String hash,
            /* Height of the block this information was generated on */
            Integer height
            //##########################################################################################################
    ) { }
}
