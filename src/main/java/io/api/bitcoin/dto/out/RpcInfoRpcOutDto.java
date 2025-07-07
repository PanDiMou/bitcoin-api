package io.api.bitcoin.dto.out;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RpcInfoRpcOutDto(
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
            /* All active commands */
            @JsonProperty("active_commands")
            List<ActiveCommand> activeCommands,
            /* The complete file path to the debug log */
            @JsonProperty("logpath")
            String logPath
            //##########################################################################################################
    ) {
        public record ActiveCommand(
                //-------
                /* The name of the RPC command */
                String method,
                /* The running time in microseconds */
                Integer duration
                //######################################################################################################
        ) { }
    }
}
