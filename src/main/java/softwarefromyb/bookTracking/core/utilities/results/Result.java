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
public class Result {

    private String message;
    
    private Boolean success;

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(String message, Boolean success) {
        this(success);
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
