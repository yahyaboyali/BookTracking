/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.WriterService;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Writer;

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
    public Result add(Writer writer){
        return this.writerService.add(writer);
    }
    
}
