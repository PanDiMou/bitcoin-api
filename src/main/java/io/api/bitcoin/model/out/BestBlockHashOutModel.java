package io.api.bitcoin.model.out;

public record BestBlockHashOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* The block hash, hex-encoded */
        String blockHash
        //##############################################################################################################
) { }
