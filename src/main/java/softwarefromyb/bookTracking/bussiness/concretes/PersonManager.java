/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwarefromyb.bookTracking.bussiness.abstracts.PersonService;
import softwarefromyb.bookTracking.core.dataAccess.PersonDao;
import softwarefromyb.bookTracking.core.utilities.entities.Person;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessDataResult;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;

@Service
public class PersonManager implements PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonManager(PersonDao personDao) {
        this.personDao = personDao;
    }
    
    @Override
    public Result add(Person person) {
        this.personDao.save(person);
        return new SuccessResult("kullanıcı eklendi");
    }

    @Override
    public DataResult<Person> getByEmail(String email) {
        return new SuccessDataResult<Person> (
        this.personDao.findByEmail(email),"bulundu e maille");
    }

    @Override
    public DataResult<List<Person>> getAll() {
        return new SuccessDataResult<List<Person>>(
        this.personDao.findAll(),"tüm kullanıcılar geldi"
        );
    }
    
}
