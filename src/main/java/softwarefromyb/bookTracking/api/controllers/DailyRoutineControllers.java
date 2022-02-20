/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.api.controllers;

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
    public Result add(@RequestBody DailyRoutine dailyRoutine){
        return this.dailyRoutineService.add(dailyRoutine);
    }
    @PostMapping("/insertDailyRoutine")
    public Result insertDailyRoutine(@RequestParam int pid,@RequestParam int bid,@RequestParam int countofpages,@RequestParam String dailyNote){
        return this.dailyRoutineService.insertDailyRoutine(pid, bid, countofpages, dailyNote);
    }
}
