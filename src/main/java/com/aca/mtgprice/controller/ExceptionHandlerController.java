package com.aca.mtgprice.controller;

import com.aca.mtgprice.model.ExceptionResponse;
import com.aca.mtgprice.model.MtgPrice;
import com.aca.mtgprice.model.MtgPriceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({MtgPriceException.class, Exception.class})
    public ResponseEntity<ExceptionResponse> handleMovieException(MtgPriceException movieException,
                                                                  HttpServletRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setMessage(movieException.getMessage());
        exceptionResponse.setRequestURI(request.getRequestURI());

        return ResponseEntity.badRequest().body(exceptionResponse);

    }
}
