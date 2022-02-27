/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwarefromyb.bookTracking.bussiness.abstracts.BookService;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorDataResult;
import softwarefromyb.bookTracking.core.utilities.results.ErrorResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.core.utilities.results.SuccessDataResult;
import softwarefromyb.bookTracking.core.utilities.results.SuccessResult;
import softwarefromyb.bookTracking.dataAccess.abstracts.BookDao;
import softwarefromyb.bookTracking.entities.concretes.Book;

/**
 *
 * @author yahya
 */
@Service
public class BookManager implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookManager(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public DataResult<List<Book>> getAll() {
        return new SuccessDataResult<List<Book>>(
                this.bookDao.findAll(), "data is listing by getAll method"
        );
    }

    @Override
    public Result add(Book book) {
        this.bookDao.save(book);
        return new SuccessResult("adding book is success");
    }

    @Override
    public DataResult<Book> getByBookName(String name) {
        return new SuccessDataResult<Book>(
                this.bookDao.getByName(name), "data has listed by bookName method"
        );
    }

    @Override
    public DataResult<List<Book>> getByWriterId(int writer_id) {
        return new SuccessDataResult<List<Book>>(
                this.bookDao.getByWriterId(writer_id), "data writer id ile geldi"
        );
    }

    @Override
    public DataResult<List<Book>> getByWriterName(String writerName) {
        if (this.bookDao.getByWriterName(writerName).isEmpty()) {
            return new ErrorDataResult<List<Book>>("böyle bir yazar yok");
        } else {
            return new SuccessDataResult<List<Book>>(
                    this.bookDao.getByWriterName(writerName), "writer name e göre data geldi"
            );
        }

    }

    @Override
    public DataResult<List<Book>> getByWriterNameAndWriterLastname(String writerName, String writerLastname) {
        return new SuccessDataResult<List<Book>>(
                this.bookDao.getByWriterNameAndWriterLastname(writerName, writerLastname),
                "data writer name and last name ile geldi"
        );
    }

    @Override
    public Result existsBookByName(String name) {
        if(this.bookDao.existsBookByName(name)){
            return new SuccessResult("data bulundu");
        }else{
            return new ErrorResult("data bulunamadı");
        }
    }

    @Override
    public DataResult<List<Book>> getByNameStartsWith(String name) {
        return new SuccessDataResult<List<Book>>(
                this.bookDao.getByNameStartsWith(name),"datalar listelendi"
        );
    }

}
