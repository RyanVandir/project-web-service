package com.ryvas.project_web_services.adapters.in.exception;

import com.ryvas.project_web_services.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidUserException.class,
            InvalidCategoryException.class,
            InvalidOrderException.class,
            InvalidPaymentException.class,
            InvalidProductException.class
    })
    public ErrorResponse handlerInvalidRequest(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            UserNotFoundException.class,
            CategoryNotFoundException.class,
            OrderNotFoundException.class,
            ProductNotFoundException.class
    })
    public ErrorResponse handlerNotFoundRequest(Exception e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
