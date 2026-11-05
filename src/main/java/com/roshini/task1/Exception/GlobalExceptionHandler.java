package com.roshini.task1.Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExpenseException.class)

    public ResponseEntity<String> handleException(ExpenseException exception){
        return ResponseEntity.status(404)
                .body(exception.getMessage());
    }
}
