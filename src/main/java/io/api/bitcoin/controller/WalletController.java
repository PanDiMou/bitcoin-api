package io.api.bitcoin.controller;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import org.springframework.http.HttpStatus;
import io.api.bitcoin.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.api.bitcoin.model.in.CreateWalletInModel;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wallet")
final class WalletController {
    //-------
    @PostMapping("/create")
    Mono<ResponseEntity<Object>> createWallet(@RequestBody final @Valid CreateWalletInModel input) {
        return walletService
                .createWallet(input)
                .map(output -> ResponseEntity.status(HttpStatus.CREATED).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    @PostMapping("/balances/{walletName}")
    Mono<ResponseEntity<Object>> getBalances(@PathVariable final String walletName,
                                             @RequestBody @Valid final InModel input) {
        return walletService
                .getBalances(walletName, input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    @PostMapping("/listwallets")
    Mono<ResponseEntity<Object>> listWallets(@RequestBody @Valid final InModel input) {
        return walletService
                .listWallets(input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    private final WalletService walletService;
    //##################################################################################################################
}
