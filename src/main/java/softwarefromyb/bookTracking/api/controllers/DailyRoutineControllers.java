/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.DailyRoutineService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO;
import softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/dailyRoutine")
@CrossOrigin
public class DailyRoutineControllers {

    private DailyRoutineService dailyRoutineService;

    @Autowired
    public DailyRoutineControllers(DailyRoutineService dailyRoutineService) {
        this.dailyRoutineService = dailyRoutineService;
    }

    @GetMapping("/getAll")
    public DataResult<List<DailyRoutine>> getAll() {
        return this.dailyRoutineService.getAll();
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> add(@Valid @RequestBody DailyRoutine dailyRoutine) {
//        return ResponseEntity.ok(this.dailyRoutineService.add(dailyRoutine));
//    }

    @PostMapping("/insertDailyRoutine")
    public ResponseEntity<?> insertDailyRoutine(@Valid @RequestParam int pid,@Valid @RequestParam int bid,@Valid @RequestParam int countofpages,@Valid @RequestParam String dailyNote) {
        return ResponseEntity.ok(this.dailyRoutineService.insertDailyRoutine(pid, bid, countofpages, dailyNote));
    }
    @GetMapping("/bookWithDailyRoutineDTO")
    public DataResult<List<BookWithDailyRoutineDto>> bookWithDailyRoutineDto(){
        return this.dailyRoutineService.getBookWithDailyRoutineDto();
    }

    @GetMapping("/getByPersonId")
    public DataResult<List<DailyRoutine>> getByPid(@RequestParam int pid) {
        return this.dailyRoutineService.getByPerson_id(pid);
    }

    @GetMapping("/getByDate")
    public DataResult<List<DailyRoutine>> getByDate(@RequestParam Date date) {
        return this.dailyRoutineService.getByDate(date);
    }

    @GetMapping("/getByDateAndPersonId")
    public DataResult<List<DailyRoutine>> getByDateAndPersonId(@RequestParam("date") Date date, @RequestParam("id") int id) {
        return this.dailyRoutineService.getByDateAndPerson_id(date, id);
    }

    @GetMapping("/getByDateAndPersonName")
    public DataResult<List<DailyRoutine>> getByDateAndPersonName(@RequestParam("date") Date date, @RequestParam("name") String personName) {
        return this.dailyRoutineService.getByDateAndPerson_personName(date, personName);
    }
    
    @GetMapping("/getByAllSortedDesc")
    public DataResult<List<DailyRoutine>> getAllSorted(){
        return this.dailyRoutineService.getAllSorted();
    }
    
    @GetMapping("/getByBookWithDailyRoutineDtoSorted")
    public DataResult<List<BookWithDailyRoutineDto>> getByBookWithDailyRoutineDtoSorted(){
        return this.dailyRoutineService.getBookWithDailyRoutineDtoSorted();
    }
    @GetMapping("/BookWithPersonWithDailyRoutineDto")
    public DataResult<List<BookWithPersonWithDailyRoutineDto>> getByBookWithPersonWithDailyRoutineDto(){
        return this.dailyRoutineService.getBookWithPersonWithDailyRoutineDto();
    }
    @GetMapping("/BookWithPersonWithDailyRoutineDtoByPerson_id")
    public DataResult<List<BookWithPersonWithDailyRoutineDto>> getByBookWithPersonWithDailyRoutineDtoByPerson_id(@RequestParam int pid){
        return this.dailyRoutineService.getBookWithPersonWithDailyRoutineDtoByPerson_id(pid);
    }
    
    @GetMapping("BookWithPersonWithDailyRoutineDtoByPerson_personName")
    public DataResult<List<BookWithPersonWithDailyRoutineDto>> getByBookWithPersonWithDailyRoutineDtoByPerson_personName(@RequestParam String personName){
        return this.dailyRoutineService.getBookWithPersonWithDailyRoutineDtoByPerson_personName(personName);
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
