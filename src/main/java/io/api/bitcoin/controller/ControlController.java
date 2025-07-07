package io.api.bitcoin.controller;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import io.api.bitcoin.model.in.InModel;
import io.api.bitcoin.utils.HandleError;
import org.springframework.http.HttpStatus;
import io.api.bitcoin.service.ControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/control")
final class ControlController {
    //-------
    @PostMapping("/uptime")
    Mono<ResponseEntity<Object>> uptime(@RequestBody @Valid final InModel input) {
        return controlService
                .uptime(input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    @PostMapping("/stop")
    Mono<ResponseEntity<Object>> stop(@RequestBody @Valid final InModel input) {
        return controlService
                .stop(input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    @PostMapping("/rpcinfo")
    Mono<ResponseEntity<Object>> rpcInfo(@RequestBody @Valid final InModel input) {
        return controlService
                .rpcInfo(input)
                .map(output -> ResponseEntity.status(HttpStatus.OK).body((Object) output))
                .onErrorResume(HandleError::internalServerError);
    }
    //##################################################################################################################

    //-------
    private final ControlService controlService;
    //##################################################################################################################
}
