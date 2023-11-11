package com.bio.time.domain.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = HttpGenericException.class)
    protected ResponseEntity<Object> handleHttpGenericException(HttpGenericException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getErrorData(), new HttpHeaders(), exception.getHttpStatus(), request);
    }

    @ExceptionHandler(value = SQLException.class)
    protected ResponseEntity<Object> handleSQLException(SQLException exception, WebRequest request) {
        Map<String, String> errorData = Map.of(
                "type", "error",
                "message", exception.getMessage());
        return handleExceptionInternal(exception, errorData, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    protected ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException exception, WebRequest request) {
        Map<String, String> errorData = Map.of(
                "type", "error",
                "message", exception.getMessage());
        return handleExceptionInternal(exception, errorData, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    //@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .reduce(new HashMap<>(),
                        (errorMap, currentError) -> {
                            String key = currentError.getCode();
                            if (currentError instanceof FieldError) {
                                key = ((FieldError) currentError).getField();
                            }
                            String message = currentError.getDefaultMessage();
                            errorMap.put(key, message);
                            return errorMap;
                        },
                        (map1, map2) -> map1);
        Map<String, Object> errorData = Map.of(
                "type", "error",
                "message", "No se pudo procesar su solicitud. Por favor revise el detalle de los errores que se presentaron",
                "errors", errors);
        return handleExceptionInternal(exception, errorData, headers, status, request);
    }
}
