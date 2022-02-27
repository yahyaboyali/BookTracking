/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.entities.dtos;

//import java.sql.Date;
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
public class BookWithDailyRoutineWithDateDTO {

    private Date date;
    private String bookName;
    private String dailyNote;
    private int countOfPages;
}
