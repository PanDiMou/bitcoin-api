package io.api.bitcoin.service.webclient;

import reactor.core.publisher.Mono;
import io.api.bitcoin.dto.in.RpcInDto;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.config.WebClientConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RpcWebClient {
    //-------
    public <T> Mono<T> requestRpc(final RpcInDto rpcInDto, final Class<T> type) {
        return webClientConfig
                .webClient()
                .post()
                .bodyValue(rpcInDto)
                .retrieve()
                .bodyToMono(type);
    }
    //##################################################################################################################

    //-------
    public <T> Mono<T> requestRpc(final RpcInDto rpcInDto, final String walletName, final Class<T> type) {
        final String uri = "wallet/" + walletName;
        return webClientConfig
                .webClient()
                .post()
                .uri(uri)
                .bodyValue(rpcInDto)
                .retrieve()
                .bodyToMono(type);
    }
    //##################################################################################################################

    //-------
    private final WebClientConfig webClientConfig;
    //##################################################################################################################
}
