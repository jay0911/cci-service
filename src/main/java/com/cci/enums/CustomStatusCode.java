package com.cci.enums;

public enum CustomStatusCode {
	USER_EXCEPTION(502, "User Exception"),
	DATE_PARSE_EXCEPTION(501, "Date parsing Exception"),
	GLOBAL_EXCEPTION(500, "generic exception");
	
	CustomStatusCode(int code, String exceptionDescription) {
		this.code = code;
		this.exceptionDescription = exceptionDescription;
	}
	public int getCode() {
		return code;
	}
	public String getExceptionDescription() {
		return exceptionDescription;
	}
	private int code;
	private String exceptionDescription;
	
}
