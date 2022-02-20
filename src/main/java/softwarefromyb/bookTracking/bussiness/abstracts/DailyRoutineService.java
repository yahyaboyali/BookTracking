/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.abstracts;

import java.util.List;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;

/**
 *
 * @author yahya
 */
public interface DailyRoutineService {

    DataResult<List<DailyRoutine>> getAll();
    
    Result add(DailyRoutine dailyRoutine);
    
    Result insertDailyRoutine(int pid,int bid,int countofpages,String dailyNote);
}
