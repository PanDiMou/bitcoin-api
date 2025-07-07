package io.api.bitcoin.model.out;

public record StopOutModel(
        //-------
        /* The unique identifier for the request. */
        String id,
        /* A string with the content 'Bitcoin Core stopping' */
        String result
        //##############################################################################################################
) { }
