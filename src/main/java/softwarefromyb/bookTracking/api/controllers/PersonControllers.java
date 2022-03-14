/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.PersonService;
import softwarefromyb.bookTracking.core.utilities.entities.Person;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.SuccessDataResult;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/persons")
public class PersonControllers {
    
    private PersonService personService;
    
    @Autowired
    public PersonControllers(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Person person) {// ders 9 2:43:46
       //@valid bunu validasyondan geçir demek
        return ResponseEntity.ok(this.personService.add(person));
    }
    
    @GetMapping("/getByEmail")
    public DataResult<Person> getByEmail(String email){
        return this.personService.getByEmail(email);
    }
    
    @GetMapping("/getAll")
    public DataResult<List<Person>> getAll(){
        return this.personService.getAll();
    }
   
}
