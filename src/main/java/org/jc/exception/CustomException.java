package org.jc.exception;

import org.jc.util.Enums.ErrorCode;

public class CustomException extends Exception{

    private ErrorCode errorCode;
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
