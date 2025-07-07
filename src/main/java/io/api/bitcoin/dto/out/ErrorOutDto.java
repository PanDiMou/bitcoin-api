package io.api.bitcoin.dto.out;

import io.api.bitcoin.utils.ErrorCode;
import org.springframework.util.ObjectUtils;

public record ErrorOutDto(
        //-------
        ErrorCode code,
        /* Warning messages, if any, related to creating and loading the wallet. */
        String message
        //##############################################################################################################
) {
    //-------
    public ErrorOutDto {
        if (ObjectUtils.isEmpty(message)) {
            code = ErrorCode.E001;
            message = "An error occurred.";
        }
    }
    //##################################################################################################################
}
