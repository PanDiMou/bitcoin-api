package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListWalletsRpcOutDto(
        //-------
        /* The wallet name */
        List<String> result,
        @JsonProperty("error")
        ErrorRpcOutDto errorRpcOutDto,
        /* The unique identifier for the request. */
        String id
        //##############################################################################################################
) implements RpcOutDto { }
