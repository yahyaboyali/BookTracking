/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.entities.dtos;

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
public class BookWithDailyRoutineDto {

    private String bookname;
    private int countofpages;
    private String dailynote;
}
