package io.api.bitcoin.dto.in;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RpcInDto(
        //-------
        @JsonProperty("jsonrpc")
        String jsonRpc,
        String id,
        String method,
        @JsonProperty("params")
        List<Object> parameters
        //##############################################################################################################
) {
    //-------
    public RpcInDto(final String id, final String method, final List<Object> parameters) {
        this("1.0", id, method, parameters);
    }
    //##################################################################################################################

    //-------
    public RpcInDto(final String id, final String method) {
        this(id, method, List.of());
    }
    //##################################################################################################################
}
