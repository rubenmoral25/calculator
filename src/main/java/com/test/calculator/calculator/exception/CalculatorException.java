package com.test.calculator.calculator.exception;

public class CalculatorException extends Exception {

	private String messageError;

	public CalculatorException(String messageError) {
		super();
		this.messageError = messageError;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
