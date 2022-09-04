package com.shumbamoney.backend.exceptions;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.shumbamoney.backend.exceptions.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class SeviceExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> duplicateKeyExceptionExceptionHandler(DuplicateKeyException ex) {
        return new ResponseEntity<>("Duplicate key constraint violation error occurred" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException ex) {

        return new ResponseEntity<>("Data constraint violation error occurred" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("Data integrity violation error occurred" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> sqlExceptionHandler(SQLException ex) {
        return new ResponseEntity<>("Data inconsistency error occurred" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> dateTimeParseExceptionHandler(DateTimeParseException ex) {
        return new ResponseEntity<>("Date input value is wrong" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error("{}", errors, ex);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> dataHandlingExceptionHandler(DataNotFoundException ex) {
        return new ResponseEntity<>("Error occurred while handling input data: Part of the input data could not be processed" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> jsonProcessingExceptionHandler(JsonProcessingException ex) {
        return new ResponseEntity<>("Error occurred in Processing a JSON request: The XML string could not be mapped" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> generalExceptionHandler(Exception ex) {

        return new ResponseEntity<>("Error Occurred: Request could not be processed" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
