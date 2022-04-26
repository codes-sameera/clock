package com.sam.clock.exception;

import com.sam.clock.model.communication.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> illegalArgumentExceptionHandler(IllegalArgumentException ex, WebRequest request) {
        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    private ResponseEntity<ErrorMessage> createErrorResponse(HttpStatus httpStatus, String ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                httpStatus.value(),
                new Date(),
                ex,
                request.getDescription(false));
        return new ResponseEntity<>(message, httpStatus);
    }
}
