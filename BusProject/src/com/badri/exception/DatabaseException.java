package com.badri.exception;

public class DatabaseException extends RuntimeException {
	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public DatabaseException() {
	}

	public DatabaseException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
