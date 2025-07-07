package io.api.bitcoin.exception;

import java.util.Objects;
import io.api.bitcoin.utils.ErrorCode;
import io.api.bitcoin.dto.out.ErrorOutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    //-------
    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorOutDto> handleValidationException(final WebExchangeBindException exception) {
        final String field = Objects
                .requireNonNull(exception.getBindingResult().getFieldError())
                .getField();

        final String response = field
                + " "
                + Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();
        return ResponseEntity.badRequest().body(new ErrorOutDto(ErrorCode.E003, response));
    }
    //##################################################################################################################

    //-------
    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<ErrorOutDto> handleValidationException(final ServerWebInputException exception) {
        return ResponseEntity.badRequest().body(new ErrorOutDto(ErrorCode.E004, "The body must not be null."));
    }
    //##################################################################################################################

    //-------
    @ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public ResponseEntity<ErrorOutDto> handleValidationException(final UnsupportedMediaTypeStatusException exception) {
        return ResponseEntity.badRequest().body(new ErrorOutDto(ErrorCode.E004, "The body must not be null."));
    }
    //##################################################################################################################
}
