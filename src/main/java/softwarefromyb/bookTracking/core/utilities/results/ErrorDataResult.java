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
public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult() {
        super(null,false);
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }
    
    public ErrorDataResult(String message){
        super(null,false,message);
    }

}
