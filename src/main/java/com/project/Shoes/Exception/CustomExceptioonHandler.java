package com.project.Shoes.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptioonHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HttpClientErrorException.class})
    protected ResponseEntity<Object> handleHttpClientErrorException(final HttpClientErrorException ex, final WebRequest request){
        return new ResponseEntity(ErrorBody.builder()
                .code(ex.getStatusCode().value())
                .message(ex.getStatusText())
                .build(), ex.getStatusCode());
    }

}
