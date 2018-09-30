package com.drebate.exception;

/**
 * @author shenlou  2017/11/1
 */
public enum BizExceptionCodeEnum {

    EX_COMPANEY_RESET(10010,"公司已存在"),
    ;

    BizExceptionCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
