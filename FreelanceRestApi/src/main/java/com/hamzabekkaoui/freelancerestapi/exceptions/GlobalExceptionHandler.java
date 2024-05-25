package com.hamzabekkaoui.freelancerestapi.exceptions;


import com.hamzabekkaoui.freelancerestapi.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionResponse resourceNotFoundException(ResourceNotFoundException ex){
        return ExceptionResponse.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }


    @ExceptionHandler(ResourceAlreadyExist.class)
    public ExceptionResponse resourceAlreadyExist(ResourceAlreadyExist ex){
        return ExceptionResponse.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }


}
