package com.example.blogsystem1.Advice;

import com.example.blogsystem1.API.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

public class AdviceController {
    @ExceptionHandler(value = ApiException.class)

    public ResponseEntity ApiException(ApiException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);


    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);


    }

    @ExceptionHandler(value =  DataIntegrityViolationException.class)
    public ResponseEntity  DataIntegrityViolationException( DataIntegrityViolationException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);


    }

    @ExceptionHandler(value =  MethodArgumentNotValidException.class)
    public ResponseEntity    MethodArgumentNotValidException(   MethodArgumentNotValidException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);


    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(     NullPointerException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);
    }

    @ExceptionHandler(value = ClassNotFoundException.class)
    public ResponseEntity ClassNotFoundException(ClassNotFoundException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body(Message);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body("Message");

    }
    @ExceptionHandler(value =  MethodArgumentTypeMismatchException.class)
    public ResponseEntity   MethodArgumentTypeMismatchException( MethodArgumentTypeMismatchException e){
        String Message = e.getMessage();
        return ResponseEntity.status(400).body("Message");

    }


}