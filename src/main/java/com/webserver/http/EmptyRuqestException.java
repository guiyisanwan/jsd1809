package com.webserver.http;
//空请求异常
//
public class EmptyRuqestException extends Exception {
	private static final long serialVersionUID = 1L;
	public EmptyRuqestException() {
		super();
		
	}
//父类的构造方法
	public EmptyRuqestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public EmptyRuqestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmptyRuqestException(String message) {
		super(message);
		
	}

	public EmptyRuqestException(Throwable cause) {
		super(cause);
		
	}

	
	

}
