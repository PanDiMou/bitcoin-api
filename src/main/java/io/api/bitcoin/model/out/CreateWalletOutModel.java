package io.api.bitcoin.model.out;

public record CreateWalletOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* The name for the new wallet. If this is a path, the wallet will be created at the path location.
        This field is required. */
        String walletName
        //##############################################################################################################
) { }
