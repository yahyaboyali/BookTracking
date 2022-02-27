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

    Book getByName(String name);

    List<Book> getByWriterId(int writer_id);

    List<Book> getByWriterName(String name);

    List<Book> getByWriterNameAndWriterLastname(String name, String lastname);

    boolean existsBookByName(String name);
    
    List<Book> getByNameStartsWith(String name);
    
    List<Book> getByNameContains(String name);
}
