/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO;

/**
 *
 * @author yahya
 */
public interface DailyRoutineDao extends JpaRepository<DailyRoutine, Integer> {

    @Modifying
    @Query(value = "insert into dailyroutine (pid,bid,countofpages,dailynote)"
            + " values(:pid,:bid,:countofpages,:dailynote)", nativeQuery = true)
    @Transactional
    void insertDailyroutine(@Param("pid") int pid, @Param("bid") int bid, @Param("countofpages") int countofpages,
            @Param("dailynote") String dailynote);

    List<DailyRoutine> getByPerson_id(@Param("pid") int pid);

    List<DailyRoutine> getByDate(Date date);

    List<DailyRoutine> getByDateAndPerson_id(Date date, int id);

    List<DailyRoutine> getByDateAndPerson_name(Date date, String name);

    //    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto"
//            + "( b.bookname, d.countofpages, d.dailynote ,d.date) "
//            + "From Book b Inner Join b.dailyroutines d")
//    //@Query(value = "SELECT new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto b.name, d.countofpages, d.dailynote From Book b INNER JOIN Dailyroutine d ON b.id=d.bid", nativeQuery = true )
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto (d.date, b.name, d.countOfPages, d.dailyNote)"
            + "From Book b Inner Join b.dailyRoutines d")
    List<BookWithDailyRoutineDto> getBookWithDailyRoutine();
    
//    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO (d.date ,b.name,d.dailyNote, d.countOfPages)"
//            + "From Book b Inner Join b.dailyRoutines d")
//    List<BookWithDailyRoutineWithDateDTO> getBookWithDailyRoutine();
}
