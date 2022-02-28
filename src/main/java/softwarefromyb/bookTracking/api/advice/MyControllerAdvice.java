/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.advice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

// @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorDataResult<Object> handleValidExceptions(MethodArgumentNotValidException exceptions) {
//        Map<String, String> validationErrors = new HashMap<String, String>();
//        for (FieldError error : exceptions.getBindingResult().getFieldErrors()) {
//            validationErrors.put(error.getField(), error.getDefaultMessage());
//        }
//        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "lütfen gerekli alanları kuralalara uygun halde doldurun");
//        return errorDataResult;
//    }
}
