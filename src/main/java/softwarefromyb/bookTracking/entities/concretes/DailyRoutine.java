/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.entities.concretes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softwarefromyb.bookTracking.core.utilities.entities.Person;

/**
 *
 * @author yahya
 */

@Data
@Entity
@Table(name="dailyroutine")
public class DailyRoutine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="countofpages")
    private int countOfPages;
    
    @Column(name="dailynote")
    private String dailyNote;
    
    
    @Column(name="date")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="pid")
    private Person person;
    
    @ManyToOne
    @JoinColumn(name="bid")
    private Book book;

//    public DailyRoutine(int countOfPages, String dailyNote, Person person, Book book) {
//        this.countOfPages = countOfPages;
//        this.dailyNote = dailyNote;
//        this.person = person;
//        this.book = book;
//    }
}
