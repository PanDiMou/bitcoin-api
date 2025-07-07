package io.api.bitcoin.model.in;

import jakarta.validation.constraints.NotBlank;

public record InModel(
        //-------
        /* The unique identifier for the request. */
        @NotBlank(message = "is required.")
        String id
        //##############################################################################################################
) { }
