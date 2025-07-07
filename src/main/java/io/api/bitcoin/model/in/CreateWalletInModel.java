package io.api.bitcoin.model.in;

import org.springframework.util.ObjectUtils;
import jakarta.validation.constraints.NotBlank;

public record CreateWalletInModel(
        //-------
        /* The unique identifier for the request. */
        @NotBlank(message = "is required.")
        String id,
        /* The name for the new wallet. If this is a path, the wallet will be created at the path location.
        This field is required. */
        @NotBlank(message = "is required.")
        String walletName,
        /* Disable the possibility of private keys (only watchonlys are possible in this mode).
        Defaults to false if not provided. */
        Boolean disablePrivateKeys,
        /* Create a blank wallet. A blank wallet has no keys or HD seed. One can be set using sethdseed.
        Defaults to false if not provided. */
        Boolean blank,
        /* Encrypt the wallet with this passphrase. Defaults to null if not provided. */
        String passPhrase,
        /* Keep track of coin reuse, and treat dirty and clean coins differently with privacy considerations in mind.
        Defaults to false if not provided. */
        Boolean avoidReuse,
        /* Create a native descriptor wallet. The wallet will use descriptors internally to handle address creation.
        Setting to "false" will create a legacy wallet;
        This is only possible with the -deprecatedrpc=create_bdb setting because,
        the legacy wallet type is being deprecated and support for creating and opening legacy wallets
        will be removed in the future. Defaults to true if not provided. */
        Boolean descriptors,
        /* Save wallet name to persistent settings and load on startup.
        True to add wallet to startup list, false to remove, null to leave unchanged.
        Defaults to null if not provided.*/
        Boolean loadOnStartup,
        /* Use an external signer such as a hardware wallet. Requires -signer to be configured.
        Wallet creation will fail if keys cannot be fetched. Requires disable_private_keys and descriptors set to true.
        Defaults to false if not provided. */
        Boolean externalSigner
        //##############################################################################################################
) {
    //-------
    public CreateWalletInModel {
        if (ObjectUtils.isEmpty(disablePrivateKeys))
            disablePrivateKeys = false;

        if (ObjectUtils.isEmpty(blank))
            blank = false;

        if (ObjectUtils.isEmpty(passPhrase))
            passPhrase = null;

        if (ObjectUtils.isEmpty(avoidReuse))
            avoidReuse = false;

        if (ObjectUtils.isEmpty(descriptors))
            descriptors = true;

        if (ObjectUtils.isEmpty(loadOnStartup))
            loadOnStartup = null;

        if (ObjectUtils.isEmpty(externalSigner))
            externalSigner = false;
    }
    //##################################################################################################################
}
