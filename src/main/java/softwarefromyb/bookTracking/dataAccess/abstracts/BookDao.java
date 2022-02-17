/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import softwarefromyb.bookTracking.entities.concretes.Book;

/**
 *
 * @author yahya
 */
public interface BookDao extends JpaRepository<Book, Integer>{
    
}
