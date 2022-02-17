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
public class DataResult<T> extends Result {
    
    private T data;

    public DataResult(T data, String message, Boolean success) {
        super(message, success);
        this.data = data;
    }

    public DataResult(T data, Boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
