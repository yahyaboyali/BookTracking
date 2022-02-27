/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwarefromyb.bookTracking.bussiness.abstracts.WriterService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessDataResult;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.dataAccess.abstracts.WriterDao;
import softwarefromyb.bookTracking.entities.concretes.Writer;

/**
 *
 * @author yahya
 */
@Service
public class WriterManager implements WriterService {

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

    @Override
    public DataResult<Writer> getById(int id) {
        if (this.writerDao.getById(id).getId() == id) {
            return new SuccessDataResult<Writer>(this.writerDao.getById(id), "id ile geldi");
        } else {
            return new ErrorDataResult<Writer>("data listelenemedi");
        }
    }

    @Override
    public Result existsById(int id) {
        if (this.writerDao.existsById(id)) {
            return new SuccessResult("data bulundu");

        } else {
            return new ErrorResult("böyle bir yazar yok");
        }
    }

    @Override
    public Result exitstsWriterByName(String name) {
        if (this.writerDao.existsWriterByName(name)) {
            return new SuccessResult("data bulundu");
        } else {
            return new ErrorResult("böyle bir yazar yok");
        }
    }

}
