/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.BookService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Book;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/books")
@CrossOrigin
public class BookControllers {

    private BookService bookService;

    @Autowired
    public BookControllers(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/getAll")
    public DataResult<List<Book>> getAll(){
        return this.bookService.getAll();
    }
    
    @PostMapping("/add")
    public Result add(@RequestBody Book book){
        return this.bookService.add(book);
    }
    
    @GetMapping("/getByBookName")
    public DataResult<Book> getByBookName(@RequestParam String bookName){
        return this.bookService.getByBookName(bookName);
    }
    
    @GetMapping("/getByWriterId")
    public DataResult<List<Book>> getByWriterId(@RequestParam int wid){
        return this.bookService.getByWriterId(wid);
    }
//    @GetMapping("/getByBookName")
//    public ResponseEntity<?> getByBookName(@Valid @RequestParam String bookName){
//        return ResponseEntity.ok(this.bookService.getByBookName(bookName));
//    }
    
    @GetMapping("/getByWriterName")
    public DataResult<List<Book>> getByWriterName(@RequestParam String writerName){
        return this.bookService.getByWriterName(writerName);
    }
    
    @GetMapping("/getByWriterNameAndWriterLastname")
    public DataResult<List<Book>> getByWriterNameAndWriterLastname(@RequestParam("writerName") String writerName,
            @RequestParam("writerLastname") String writerLastname){
        return this.bookService.getByWriterNameAndWriterLastname(writerName, writerLastname);
    }
    
    @GetMapping("/exitstBookByName")
    public Result existsBookByName(String bookName){
        return this.bookService.existsBookByBookName(bookName);
    }
    
    @GetMapping("/getByBookNameStartsWith")
    public DataResult<List<Book>> getByNameStartsWith(String bookName){
        return this.bookService.getByBookNameStartsWith(bookName);
    }
    
    @GetMapping("/getByNameContains")
    public DataResult<List<Book>> getByNameContains(String bookName){
        return this.bookService.getByBookNameContains(bookName);
    }
    
}
