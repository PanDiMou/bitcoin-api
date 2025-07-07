package io.api.bitcoin.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateWalletRpcOutDto(
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
            /* The wallet name if created successfully.
            If the wallet was created using a full path, the wallet_name will be the full path. */
            String name
            //##########################################################################################################
    ) { }
}
