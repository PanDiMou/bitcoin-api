package io.api.bitcoin.service;

import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.dto.in.RpcInDto;
import org.springframework.stereotype.Service;
import io.api.bitcoin.dto.out.BalancesRpcOutDto;
import io.api.bitcoin.webclient.RpcWebClient;

@Service
@RequiredArgsConstructor
public final class WalletService {
    //-------
    public Mono<BalancesRpcOutDto> getBalances(final String walletName, final RpcInDto input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "getbalances"), walletName, BalancesRpcOutDto.class)
                .onErrorMap(throwable -> new RuntimeException("Erreur lors de la récupération des balances pour wallet: " + walletName, throwable));
    }
    //##################################################################################################################

    //-------
    private final RpcWebClient rpcWebClient;
    //##################################################################################################################
}
