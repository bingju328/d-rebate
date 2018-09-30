package com.drebate.exception;

public class BizException extends RuntimeException {

	private int code;

	private String message;

	private Object data;

	public BizException(int code) {
		super();
		this.code = code;
	}

	public BizException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BizException(BizExceptionCodeEnum bizExceptionCodeEnum) {
		super(bizExceptionCodeEnum.getMessage());
		this.code = bizExceptionCodeEnum.getCode();
		this.message = bizExceptionCodeEnum.getMessage();
	}

	public BizException(BizExceptionCodeEnum bizExceptionCodeEnum, String data) {
		super(bizExceptionCodeEnum.getMessage());
		this.code = bizExceptionCodeEnum.getCode();
		this.message = bizExceptionCodeEnum.getMessage() + " data=" + data;
	}

	public BizException(int code, String message, Object data) {
		super(message);
		this.code = code;
		this.message = message;
		this.data = data;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
