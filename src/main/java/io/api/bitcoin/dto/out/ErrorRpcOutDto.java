package io.api.bitcoin.dto.out;

public record ErrorRpcOutDto(
        //-------
        Integer code,
        /* Warning messages, if any, related to creating and loading the wallet. */
        String message
        //##############################################################################################################
) { }
