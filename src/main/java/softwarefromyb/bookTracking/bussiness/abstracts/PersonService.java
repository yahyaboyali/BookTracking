/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.abstracts;

import java.util.List;
import softwarefromyb.bookTracking.core.utilities.entities.Person;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;

/**
 *
 * @author yahya
 */
public interface PersonService {

    Result add(Person person);

    DataResult<Person> getByEmail(String email);

    DataResult<List<Person>> getAll();
}
