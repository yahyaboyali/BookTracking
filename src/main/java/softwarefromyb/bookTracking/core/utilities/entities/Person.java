/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.core.utilities.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softwarefromyb.bookTracking.entities.concretes.Book;
import softwarefromyb.bookTracking.entities.concretes.DailyRoutine;

/**
 *
 * @author yahya
 */
@Entity
@Data
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","dailyRoutines"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Email
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;
    
    @NotNull
    @NotBlank
    @Column(name="password")
    private String password;
    
    @OneToMany(mappedBy = "person")
    private List<DailyRoutine> dailyRoutines;

    public Person(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    
    
}
