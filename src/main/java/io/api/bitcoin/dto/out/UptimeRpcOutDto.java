package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UptimeRpcOutDto(
        //-------
        /* The number of seconds that the server has been running */
        Integer result,
        @JsonProperty("error")
        ErrorRpcOutDto errorRpcOutDto,
        /* The unique identifier for the request. */
        String id
        //##############################################################################################################
) implements RpcOutDto { }
