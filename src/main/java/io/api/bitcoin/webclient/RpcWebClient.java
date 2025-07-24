package io.api.bitcoin.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import io.api.bitcoin.dto.in.RpcInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RpcWebClient {

    //-------
    public <T> Mono<T> requestRpc(final RpcInDto rpcInDto, final String walletName, final Class<T> type) {
        final String uri = "wallet/" + walletName;
        return webClient
                .post()
                .uri(uri)
                .bodyValue(rpcInDto)
                .retrieve()
                .bodyToMono(type);
    }
    //##################################################################################################################

    //-------
    private final WebClient webClient;
    //##################################################################################################################
}
