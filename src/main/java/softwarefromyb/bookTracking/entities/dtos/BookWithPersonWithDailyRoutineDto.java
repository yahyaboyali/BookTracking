/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.entities.dtos;



import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yahya
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithPersonWithDailyRoutineDto {

    private String personName;
    private String personLastName;
    private String bookName;
    private int numberOfPages;
    private String writerName;
    private String writerLastName;
    private Date date;
    private String dailyNote;
    private int countOfPages;



   

   

   







    
    

}
