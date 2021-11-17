package com.org.robotfactory.controller;

import com.org.robotfactory.exception.StockNotAvailableException;
import com.org.robotfactory.exception.NonUniquePartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RobotFactoryControllerAdvice {

    @ExceptionHandler(StockNotAvailableException.class)
    public ResponseEntity stockNotAvailableException(StockNotAvailableException ex) {
        return new ResponseEntity(ex.getMessage() + ex.getGot() + ex.getField(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NonUniquePartException.class)
    public ResponseEntity nonUniquePartException(NonUniquePartException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
