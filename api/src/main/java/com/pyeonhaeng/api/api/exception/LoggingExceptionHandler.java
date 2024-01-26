package com.pyeonhaeng.api.api.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class LoggingExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception e, WebRequest request){

        log.error("error : {}  |  request : {}",e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

}
