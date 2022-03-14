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
import softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto;
import softwarefromyb.bookTracking.entities.dtos.DailyRoutineWithPersonDto;

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

    List<DailyRoutine> getByDateAndPerson_personName(Date date, String personName);

    //    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto"
//            + "( b.bookname, d.countofpages, d.dailynote ,d.date) "
//            + "From Book b Inner Join b.dailyroutines d")
//    //@Query(value = "SELECT new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto b.name, d.countofpages, d.dailynote From Book b INNER JOIN Dailyroutine d ON b.id=d.bid", nativeQuery = true )
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto (d.date, b.bookName, d.countOfPages, d.dailyNote)"
            + "From Book b Inner Join b.dailyRoutines d")
    List<BookWithDailyRoutineDto> getBookWithDailyRoutine();
    
//    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineWithDateDTO (d.date ,b.name,d.dailyNote, d.countOfPages)"
//            + "From Book b Inner Join b.dailyRoutines d")
//    List<BookWithDailyRoutineWithDateDTO> getBookWithDailyRoutine();
    /*
     private Date date;
    private String bookname;
    private int countofpages;
    private String dailynote;
    */
//    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto (d.date, b.bookName, d.countOfPages, d.dailyNote)"
//            + "From Book b Inner Join b.dailyRoutines d order by d.date desc")
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithDailyRoutineDto (d.date, b.bookName, d.countOfPages, d.dailyNote)"
            + "From Book b, DailyRoutine d Where b.id=d.book.id Order By d.date desc") 
    List<BookWithDailyRoutineDto> getBookWithDailyRoutineSorted();

//    @Query("Select new softwarefromyb.bookTracking.entities.dtos.getBookWithPersonWithDailyRoutine "
//            + "(b.name,b.numberOfPages,w.name,w.lastname,d.date,d.dailyNote,d.countOfPages)"
//            + " From Writer w,Person p, ")
    //(String personName, String personLastName, String bookName, int numberOfPages,
    //String writerName, String writerLastName, Date date, String dailyNote, int countOfPages)
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto"
            + "(p.personName,p.personLastName,b.bookName,b.numberOfPages,w.writerName,w.writerLastName,d.date,d.dailyNote,d.countOfPages)"
            + "From DailyRoutine AS d, Book AS b, Writer AS w, Person AS p"
            + " Where p.id=d.person.id And b.id=d.book.id And b.writer.id=w.id") 
    List<BookWithPersonWithDailyRoutineDto> getBookWithPersonWithDailyRoutine(); 
    
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto"
            + "(p.personName,p.personLastName,b.bookName,b.numberOfPages,w.writerName,w.writerLastName,d.date,d.dailyNote,d.countOfPages)"
            + "From DailyRoutine AS d, Book AS b, Writer AS w, Person AS p"
            + " Where p.id=d.person.id And b.id=d.book.id And b.writer.id=w.id And p.id=:pid")  
    List<BookWithPersonWithDailyRoutineDto> getBookWithPersonWithDailyRoutineByPerson_id(@Param("pid") int pid);
    
    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto"
            + "(p.personName,p.personLastName,b.bookName,b.numberOfPages,w.writerName,w.writerLastName,d.date,d.dailyNote,d.countOfPages)"
            + "From DailyRoutine AS d, Book AS b, Writer AS w, Person AS p"
            + " Where p.id=d.person.id And b.id=d.book.id And b.writer.id=w.id And p.personName=:personName")  
    List<BookWithPersonWithDailyRoutineDto> getBookWithPersonWithDailyRoutineByPerson_personName(@Param("personName") String personName);
    /*
    java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.util.Date, java.lang.String, int
    public BookWithPersonWithDailyRoutineDto(String personName, String personLastName, String bookName, int numberOfPages, String writerName, String writerLastName, Date date, String dailyNote, int countOfPages) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.writerName = writerName;
        this.writerLastName = writerLastName;
        this.date = date;
        this.dailyNote = dailyNote;
        this.countOfPages = countOfPages;
    }
    
    private String personName;
    private String personLastName;
    private String bookName;
    private int numberOfPages;
    private String writerName;
    private String writerLastName;
    private Date date;
    private String dailyNote;
    private int countOfPages;
     */
//    @Query("Select")
//    List< DailyRoutineWithPersonDto> getByDailyRoutineWithPersonDto();
    
//    @Query("Select new softwarefromyb.bookTracking.entities.dtos.BookWithPersonWithDailyRoutineDto "
//            + "p.name,p.lastName,b.name")
//    List<BookWithPersonWithDailyRoutineDto> getByBookWithPersonWithDailyRoutineDto();
}
