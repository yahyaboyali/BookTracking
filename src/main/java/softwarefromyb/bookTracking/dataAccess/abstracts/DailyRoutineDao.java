/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.dataAccess.abstracts;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;
import softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto;

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

//    @Query(value = "Select new softwarefromyb.bookTracking.entities.dtos"
//            + "(b.name, d.countofpages,d.dailynote) "
//            + "From Book d INNER JOIN  b ")
//    List<BookWithDailyRoutineDto> getBookWithDailyRoutine();
}
