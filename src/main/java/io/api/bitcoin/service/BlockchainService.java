package io.api.bitcoin.service;

import reactor.core.publisher.Mono;
import io.api.bitcoin.dto.in.RpcInDto;
import io.api.bitcoin.utils.Converter;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import org.springframework.stereotype.Service;
import io.api.bitcoin.service.webclient.RpcWebClient;
import io.api.bitcoin.dto.out.BestBlockHashRpcOutDto;
import io.api.bitcoin.model.out.BestBlockHashOutModel;
import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public final class BlockchainService {
    //-------
    public Mono<BestBlockHashOutModel> getBestBlockHash(final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "getbestblockhash"), BestBlockHashRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, BestBlockHashRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    private final RpcWebClient rpcWebClient;
    //##################################################################################################################
}
