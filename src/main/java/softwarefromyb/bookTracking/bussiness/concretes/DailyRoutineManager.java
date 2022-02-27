/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.concretes;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softwarefromyb.bookTracking.bussiness.abstracts.DailyRoutineService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessDataResult;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.dataAccess.abstracts.DailyRoutineDao;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO;

/**
 *
 * @author yahya
 */
@Service
public class DailyRoutineManager implements DailyRoutineService{
    
    private DailyRoutineDao dailyRoutineDao;
    
    @Autowired
    public DailyRoutineManager(DailyRoutineDao dailyRoutineDao){
        this.dailyRoutineDao=dailyRoutineDao;
    }
    @Override
    public DataResult<List<DailyRoutine>> getAll() {
        return new SuccessDataResult<List<DailyRoutine>>(
                this.dailyRoutineDao.findAll(),"tüm datalar geldi"
        );
    }

    @Override
    public Result add(DailyRoutine dailyRoutine) {
        this.dailyRoutineDao.save(dailyRoutine);
        return new SuccessResult("adding daily routine ");
    }

    @Override
    public Result insertDailyRoutine(int pid, int bid, int countofpages, String dailyNote) {
        this.dailyRoutineDao.insertDailyroutine(pid, bid, countofpages, dailyNote);
        return new SuccessResult("adding daily routine insertdaily");
    }

    @Override
    public DataResult<List<BookWithDailyRoutineDto>> getBookWithDailyRoutineDto() {
        return new SuccessDataResult<List<BookWithDailyRoutineDto>> (
                this.dailyRoutineDao.getBookWithDailyRoutine(),"data listelendi"
        );
    }

    @Override
    public DataResult<List<DailyRoutine>> getByPerson_id(int pid) {
        return new SuccessDataResult<List<DailyRoutine>> (
        this.dailyRoutineDao.getByPerson_id(pid),"data person id ile listelendi");
    }

    @Override
    public DataResult<List<DailyRoutine>> getByDate(Date date) {
        return new SuccessDataResult<List<DailyRoutine>>(
                this.dailyRoutineDao.getByDate(date),"data date e göre listelendi"
        );
    }

    @Override
    public DataResult<List<DailyRoutine>> getByDateAndPerson_id(Date date, int id) {
        return new SuccessDataResult<List<DailyRoutine>>(
                this.dailyRoutineDao.getByDateAndPerson_id(date, id),"data person id ve date e göre geldi"
        );
    }

    @Override
    public DataResult<List<DailyRoutine>> getByDateAndPerson_name(Date date, String name) {
        return new SuccessDataResult<List<DailyRoutine>>(
                this.dailyRoutineDao.getByDateAndPerson_name(date, name),"data person name ve date e göre geldi"
        );
    }

    @Override
    public DataResult<List<DailyRoutine>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"date");
        
        return new SuccessDataResult<List<DailyRoutine>>(this.dailyRoutineDao.findAll(sort),"daily routine desc olarak listelendi");
    }

   
    
}
