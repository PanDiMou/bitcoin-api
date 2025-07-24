package io.api.bitcoin.controller;

import io.api.bitcoin.dto.in.RpcInDto;
import io.api.bitcoin.dto.out.BalancesRpcOutDto;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import io.api.bitcoin.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wallet")
final class WalletController {
    //-------
    @PostMapping("/balances/{walletName}")
    Mono<ResponseEntity<BalancesRpcOutDto>> getBalances(@PathVariable final String walletName,
                                                        @RequestBody @Valid final RpcInDto input) {
        return walletService
                .getBalances(walletName, input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body(output));
    }
    //##################################################################################################################

    //-------
    private final WalletService walletService;
    //##################################################################################################################
}
