package io.api.bitcoin.service;

import java.util.Arrays;
import java.util.ArrayList;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.utils.Converter;
import io.api.bitcoin.dto.in.RpcInDto;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import org.springframework.util.ObjectUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import io.api.bitcoin.dto.out.BalancesRpcOutDto;
import io.api.bitcoin.model.out.BalancesOutModel;
import io.api.bitcoin.dto.out.ListWalletsRpcOutDto;
import io.api.bitcoin.model.in.CreateWalletInModel;
import io.api.bitcoin.dto.out.CreateWalletRpcOutDto;
import io.api.bitcoin.model.out.ListWalletsOutModel;
import io.api.bitcoin.service.webclient.RpcWebClient;
import io.api.bitcoin.model.out.CreateWalletOutModel;
import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public final class WalletService {
    //-------
    public Mono<CreateWalletOutModel> createWallet(final CreateWalletInModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "createwallet", new ArrayList<>(
                        Arrays.asList(
                                ObjectUtils.isEmpty(input.walletName())
                                        ? Strings.EMPTY
                                        : input.walletName(),
                                input.disablePrivateKeys(),
                                input.blank(),
                                input.passPhrase(),
                                input.avoidReuse(),
                                input.descriptors(),
                                input.loadOnStartup(),
                                input.externalSigner()
                        )
                )), CreateWalletRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, CreateWalletRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    public Mono<BalancesOutModel> getBalances(final String walletName, final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "getbalances"), walletName, BalancesRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, BalancesRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    public Mono<ListWalletsOutModel> listWallets(final InModel input) {
        return rpcWebClient
                .requestRpc(new RpcInDto(input.id(), "listwallets"), ListWalletsRpcOutDto.class)
                .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                .onErrorResume(throwable -> HandleError.webClientError(throwable, ListWalletsRpcOutDto.class)
                        .flatMap(output -> Mono.just(Converter.toOutModel(output)))
                );
    }
    //##################################################################################################################

    //-------
    private final RpcWebClient rpcWebClient;
    //##################################################################################################################
}
