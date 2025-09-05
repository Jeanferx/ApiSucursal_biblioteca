package com.example.demo.exception;

public class ExcepcionSuc extends RuntimeException{
	private static final long serialVersionUID=1L;
	public ExcepcionSuc() {
		super();
	}
	public ExcepcionSuc(String message) {
		super(message);
	}
}
