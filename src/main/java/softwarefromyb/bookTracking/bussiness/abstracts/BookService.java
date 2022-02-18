/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.abstracts;

import java.util.List;
import softwarefromyb.bookTracking.core.utilities.results.DataResult;
import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Book;

/**
 *
 * @author yahya
 */
public interface BookService {
    DataResult<List<Book>> getAll();
    
    Result add(Book book);
    
    DataResult<Book> getByBookName(String bookName);
    
    
    DataResult<List<Book>> getByWriterId(int writerId);
  // name ile çalışıyor id ile çalışmıyor çözümümü izle   
}
