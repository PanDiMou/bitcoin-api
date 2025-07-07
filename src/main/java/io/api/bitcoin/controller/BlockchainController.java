package io.api.bitcoin.controller;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.api.bitcoin.service.BlockchainService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blockchain")
final class BlockchainController {
    //-------
    @PostMapping("/bestblockhash")
    Mono<ResponseEntity<Object>> getBestBlockHash(@RequestBody @Valid final InModel input) {
        return blockchainService
                .getBestBlockHash(input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    private final BlockchainService blockchainService;
    //##################################################################################################################
}
