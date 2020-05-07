package br.inatel.dm112.rest.support;

public class OrderDuplicateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderDuplicateException() {
	}

	public OrderDuplicateException(String message) {
		super(message);
	}

	public OrderDuplicateException(Throwable cause) {
		super(cause);
	}

	public OrderDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
