/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.BookService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
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

}
