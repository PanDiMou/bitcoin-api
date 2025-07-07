package io.api.bitcoin.model.out;

import java.util.List;

public record RpcInfoOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* All active commands */
        List<ActiveCommand> activeCommands,
        /* The complete file path to the debug log */
        String logPath
        //##############################################################################################################
) {
    public record ActiveCommand(
            //-------
            /* The name of the RPC command */
            String method,
            /* The running time in microseconds */
            Integer duration
            //##########################################################################################################
    ) { }
}
