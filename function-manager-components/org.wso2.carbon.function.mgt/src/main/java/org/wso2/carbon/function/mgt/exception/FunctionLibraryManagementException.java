package org.wso2.carbon.function.mgt.exception;

public class FunctionLibraryManagementException extends Exception{
    private String message;


    public  FunctionLibraryManagementException (String message) {
        super(message);
        this.message = message;
    }

    public  FunctionLibraryManagementException (String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
