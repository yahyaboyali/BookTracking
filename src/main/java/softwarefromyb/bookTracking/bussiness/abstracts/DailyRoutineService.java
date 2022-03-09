/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.abstracts;

import java.sql.Date;
import java.util.List;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO;
import softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto;

/**
 *
 * @author yahya
 */
public interface DailyRoutineService {

    DataResult<List<DailyRoutine>> getAll();

    Result add(DailyRoutine dailyRoutine);

    Result insertDailyRoutine(int pid, int bid, int countofpages, String dailyNote);

    DataResult<List<BookWithDailyRoutineDto>> getBookWithDailyRoutineDto();

    DataResult<List<DailyRoutine>> getByPerson_id(int pid);

    DataResult<List<DailyRoutine>> getByDate(Date date);

    DataResult<List<DailyRoutine>> getByDateAndPerson_id(Date date, int id);

    DataResult<List<DailyRoutine>> getByDateAndPerson_name(Date date, String name);

    DataResult<List<DailyRoutine>> getAllSorted();
    
    DataResult<List<BookWithDailyRoutineDto>> getBookWithDailyRoutineDtoSorted();
    
   // DataResult<List<BookWithPersonWithDailyRoutineDto>> getBookWithPersonWithDailyRoutineDto();
}
