package com.aca.mtgprice.controller;

import com.aca.mtgprice.model.ExceptionResponse;
import com.aca.mtgprice.model.CardException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ CardException.class, Exception.class })
    public ResponseEntity<ExceptionResponse> handleMovieException(CardException cardException,
            HttpServletRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setMessage(cardException.getMessage());
        exceptionResponse.setRequestURI(request.getRequestURI());

        return ResponseEntity.badRequest().body(exceptionResponse);

    }
}
