/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import softwarefromyb.bookTracking.bussiness.abstracts.DailyRoutineService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("api/dailyRoutine")
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

    @PostMapping("/add")
    public Result add(@RequestBody DailyRoutine dailyRoutine) {
        return this.dailyRoutineService.add(dailyRoutine);
    }

    @PostMapping("/insertDailyRoutine")
    public Result insertDailyRoutine(@RequestParam int pid, @RequestParam int bid, @RequestParam int countofpages, @RequestParam String dailyNote) {
        return this.dailyRoutineService.insertDailyRoutine(pid, bid, countofpages, dailyNote);
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
    public DataResult<List<DailyRoutine>> getByDateAndPersonName(@RequestParam("date") Date date, @RequestParam("name") String name) {
        return this.dailyRoutineService.getByDateAndPerson_name(date, name);
    }
    
    @GetMapping("/getByAllSortedDesc")
    public DataResult<List<DailyRoutine>> getAllSorted(){
        return this.dailyRoutineService.getAllSorted();
    }
}
