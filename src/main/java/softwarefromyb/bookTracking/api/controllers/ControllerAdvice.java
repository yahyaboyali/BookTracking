/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;

/**
 *
 * @author yahya
 */
public class ControllerAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorDataResult<Object> HandleNoSuchElementException(NoSuchElementException elementException){
        return new ErrorDataResult<Object>("hata var ");
    }
}
