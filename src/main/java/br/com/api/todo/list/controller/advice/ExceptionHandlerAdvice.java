package br.com.api.todo.list.controller.advice;

import br.com.api.todo.list.VO.HttpGenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<HttpGenericResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                .status("NOK")
                .message(ex.getBindingResult().getFieldError().getDefaultMessage())
                .response(null)
                .build(), HttpStatus.BAD_REQUEST);

        // return "Campo: " + ex.getBindingResult().getFieldError().getField() + " - Descrição erro: " + ex.getBindingResult().getFieldError().getDefaultMessage();
    }
}
