/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.HashMap;
import java.util.Map;
import javassist.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Writer;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> add(@Valid @RequestBody Writer writer) {
        return ResponseEntity.ok(this.writerService.add(writer));
    }

//    @GetMapping("/getById")
//    public DataResult getById(int id) {
//        return this.writerService.getById(id);
//    }
    @GetMapping("/getByNameIs")
    public Result existsByWriterByName(String writerName) {
        return this.writerService.exitstsWriterByWriterName(writerName);
    }

    @GetMapping("/getById")
    ResponseEntity<?> getById (@RequestParam int id) {
        return ResponseEntity.ok(this.writerService.getById(id));
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDataResult<Object> entityNotFound(HttpMessageNotWritableException exceptions) {
        
        return new ErrorDataResult<Object>(
                "data is not exist by this id"
        );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidExceptions(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError error : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "lütfen gerekli alanları kuralalara uygun halde doldurun");
        return errorDataResult; 
    }
}
