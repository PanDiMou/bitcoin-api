package io.api.bitcoin.model.out;

import java.util.List;

public record ListWalletsOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* The wallet name */
        List<String> walletNames
        //##############################################################################################################
) { }
