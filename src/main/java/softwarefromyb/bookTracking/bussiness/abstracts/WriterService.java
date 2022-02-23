/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.bussiness.abstracts;

import softwarefromyb.bookTracking.core.utilities.results.Result;
import softwarefromyb.bookTracking.entities.concretes.Writer;

/**
 *
 * @author yahya
 */
public interface WriterService {
   // Writer getByName();
    
    Result add(Writer writer);
}
