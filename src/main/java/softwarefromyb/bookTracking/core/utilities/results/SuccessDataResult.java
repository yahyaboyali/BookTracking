/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarefromyb.bookTracking.core.utilities.results;

/**
 *
 * @author yahya
 */
public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data,  String message) {
        super(data, true, message);
    }
    
    public SuccessDataResult(String message){
        super(null,true,message);
    }
    
    public SuccessDataResult(){
        super(null,true);
    }

   
    
   
}
