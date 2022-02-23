/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwarefromyb.bookTracking.bussiness.abstracts.WriterService;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.dataAccess.abstracts.WriterDao;
import softwarefromyb.bookTracking.entities.concretes.Writer;

/**
 *
 * @author yahya
 */
@Service
public class WriterManager implements WriterService{
    
    private WriterDao writerDao;
    
    @Autowired
    public WriterManager(WriterDao writerDao) {
        this.writerDao = writerDao;
    }
    
    @Override
    public Result add(Writer writer) {
        this.writerDao.save(writer);
        return new SuccessResult("yazar eklendi");
    }
    
}
