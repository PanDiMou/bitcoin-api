package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BestBlockHashRpcOutDto(
        //-------
        /* The block hash, hex-encoded */
        String result,
        @JsonProperty("error")
        ErrorRpcOutDto errorRpcOutDto,
        /* The unique identifier for the request. */
        String id
        //##############################################################################################################
) implements RpcOutDto { }
