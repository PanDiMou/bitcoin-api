package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StopRpcOutDto(
        //-------
        /* A string with the content 'Bitcoin Core stopping' */
        String result,
        @JsonProperty("error")
        ErrorRpcOutDto errorRpcOutDto,
        /* The unique identifier for the request. */
        String id
        //##############################################################################################################
) implements RpcOutDto { }
