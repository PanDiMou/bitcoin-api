package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BalancesRpcOutDto(
        //-------
        Result result,
        @JsonProperty("error")
        ErrorRpcOutDto errorRpcOutDto,
        /* The unique identifier for the request. */
        String id
        //##############################################################################################################
) implements RpcOutDto {
    public record Result(
            //-------
            /* Balances from outputs that the wallet can sign */
            Mine mine,
            /* Watchonly balances (not present if wallet does not watch anything) */
            @JsonProperty("watchonly")
            WatchOnly watchOnly,
            /* Hash and height of the block this information was generated on */
            @JsonProperty("lastprocessedblock")
            LastProcessedBlock lastProcessedBlock
            //##########################################################################################################
    ) {
        public record Mine(
                //-------
                /* Trusted balance (outputs created by the wallet or confirmed outputs) */
                Double trusted,
                /* Untrusted pending balance (outputs created by others that are in the mempool) */
                @JsonProperty("untrusted_pending")
                Double untrustedPending,
                /* Balance from immature coinbase outputs */
                Double immature,
                /* (only present if avoid_reuse is set) balance from coins sent to addresses that were previously
                spent from (potentially privacy violating) */
                Double used
                //######################################################################################################
        ) { }

        public record WatchOnly(
                //-------
                /* Trusted balance (outputs created by the wallet or confirmed outputs) */
                Double trusted,
                /* Untrusted pending balance (outputs created by others that are in the mempool) */
                @JsonProperty("untrusted_pending")
                Double untrustedPending,
                /* Balance from immature coinbase outputs */
                Double immature
                //######################################################################################################
        ) { }

        public record LastProcessedBlock(
                //-------
                /* Hash of the block this information was generated on */
                String hash,
                /* Height of the block this information was generated on */
                Integer height
                //######################################################################################################
        ) { }
    }
}
