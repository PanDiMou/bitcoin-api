package io.api.bitcoin.model.out;

public record UptimeOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* The number of seconds that the server has been running */
        Integer time
        //##############################################################################################################
) { }
