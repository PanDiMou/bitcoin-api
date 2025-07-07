package io.api.bitcoin.service;

import reactor.core.publisher.Mono;
import io.api.bitcoin.utils.Converter;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.dto.in.RpcInDto;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import io.api.bitcoin.dto.out.StopRpcOutDto;
import io.api.bitcoin.model.out.StopOutModel;
import org.springframework.stereotype.Service;
import io.api.bitcoin.dto.out.UptimeRpcOutDto;
import io.api.bitcoin.dto.out.RpcInfoRpcOutDto;
import io.api.bitcoin.model.out.UptimeOutModel;
import io.api.bitcoin.model.out.RpcInfoOutModel;
import io.api.bitcoin.service.webclient.RpcWebClient;

@Service
@RequiredArgsConstructor
public final class ControlService {
    //-------
    public Mono<UptimeOutModel> uptime(final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "uptime"), UptimeRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, UptimeRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    public Mono<StopOutModel> stop(final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "stop"), StopRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, StopRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    public Mono<RpcInfoOutModel> rpcInfo(final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "getrpcinfo"), RpcInfoRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, RpcInfoRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    private final RpcWebClient rpcWebClient;
    //##################################################################################################################
}
