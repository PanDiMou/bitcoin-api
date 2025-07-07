package io.api.bitcoin.utils;

import reactor.core.publisher.Mono;
import io.api.bitcoin.dto.out.RpcOutDto;
import io.api.bitcoin.dto.out.ErrorOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;

import org.springframework.web.reactive.function.client.WebClientResponseException;

public class HandleError {
    //-------
    public static <T extends RpcOutDto> Mono<T> webClientError(final Throwable throwable, final Class<T> type) {
        T output = null;
        if (throwable instanceof WebClientResponseException webClientResponseException) {
            output = webClientResponseException.getResponseBodyAs(type);
        }

        return (ObjectUtils.isEmpty(output)
                || ObjectUtils.isEmpty(output.errorRpcOutDto())
                || ObjectUtils.isEmpty(output.errorRpcOutDto().message()))
                ? Mono.error(new Error(Strings.EMPTY, throwable))
                : Mono.error(new Error(output.errorRpcOutDto().message(), throwable));
    }
    //##################################################################################################################

    //-------
    public static Mono<ResponseEntity<Object>> internalServerError(final Throwable throwable) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorOutDto(
                        ErrorCode.E002,
                        throwable.getMessage())
                )
        );
    }
    //##################################################################################################################
}
