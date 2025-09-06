package com.example.demo.controller.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.ExcepcionCiudad;
import com.example.demo.exception.ExcepcionSuc;
import com.example.demo.exception.SucursalInvalidaException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdviceSuc {

    // Manejo de excepciones de validación (@Valid) para DtoRequestSuc
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        
        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::formatFieldError)
                .collect(Collectors.toList());

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(errorMessages);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Manejo de SucursalInvalidaException (excepción hija)
    @ExceptionHandler(SucursalInvalidaException.class)
    public ResponseEntity<ErrorMessage> handleSucursalInvalidaException(
            SucursalInvalidaException ex, WebRequest request) {
        
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(List.of(ex.getMessage()));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Manejo de ExcepcionSuc (excepción padre - para cualquier otra excepción de esta familia)
    @ExceptionHandler(ExcepcionSuc.class)
    public ResponseEntity<ErrorMessage> handleExcepcionSuc(
            ExcepcionSuc ex, WebRequest request) {
        
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(List.of(ex.getMessage()));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Manejo de NullPointerException (para datos null)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorMessage> handleNullPointerException(
            NullPointerException ex, WebRequest request) {
        
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(List.of("El dato no puede ser nulo"));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Manejo general de otras excepciones
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGeneralException(
            Exception ex, WebRequest request) {
        
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(List.of("Error interno del servidor: " + ex.getMessage()));

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ExcepcionCiudad.class)
    public ResponseEntity<ErrorMessage> handleCiudadInvalidaException(
    		ExcepcionCiudad ex, WebRequest request) {
        
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessages(List.of(ex.getMessage()));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    private String formatFieldError(FieldError fieldError) {
        return String.format("Campo '%s': %s. Valor recibido: %s", 
                fieldError.getField(), 
                fieldError.getDefaultMessage(), 
                fieldError.getRejectedValue());
    }
}