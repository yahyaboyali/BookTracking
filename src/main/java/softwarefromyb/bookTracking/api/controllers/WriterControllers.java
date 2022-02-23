/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.WriterService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Writer;
import softwarefromyb.bookTracking.exceptions.EntityNotFoundException;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/writers")
@CrossOrigin
public class WriterControllers {

    private WriterService writerService;

    @Autowired
    public WriterControllers(WriterService writerService) {
        this.writerService = writerService;
    }

    @PostMapping("/add")
    public Result add(Writer writer) {
        return this.writerService.add(writer);
    }

    @GetMapping("/getById")
    public DataResult getById(int id) {
        return this.writerService.getById(id);
    }

    @GetMapping("/getByIdValid")
    ResponseEntity<?> getByIdValid(@RequestBody int id) {
        return ResponseEntity.ok(this.writerService.getById(id));
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> entityNotFound(){
        return new ErrorDataResult<Object> (
                "bulunamadı"
        );
    }
    
    
}
