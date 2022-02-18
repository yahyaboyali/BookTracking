/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.core.dataAccess;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import softwarefromyb.bookTracking.core.utilities.entities.Person;

/**
 *
 * @author yahya
 */
public interface PersonDao extends JpaRepository<Person, Integer> {

    Person findByEmail(String email);
}
