/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import softwarefromyb.bookTracking.entities.concretes.Book;

/**
 *
 * @author yahya
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    Book getByBookName(String bookName);

    List<Book> getByWriter_Id(int writer_id);

    List<Book> getByWriter_writerName(String writerName);

    List<Book> getByWriter_WriterNameAndWriter_WriterLastName(String writerName, String writerLastName);

    boolean existsBookByBookName(String bookName);
    
    List<Book> getByBookNameStartsWith(String bookName);
    
    List<Book> getByBookNameContains(String bookName);
}
