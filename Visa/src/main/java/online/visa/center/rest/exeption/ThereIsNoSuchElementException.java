package online.visa.center.rest.exeption;

public class ThereIsNoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = 4410809412296528155L;

	public ThereIsNoSuchElementException() {
	}

	public ThereIsNoSuchElementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ThereIsNoSuchElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public ThereIsNoSuchElementException(String message) {
		super(message);
	}

	public ThereIsNoSuchElementException(Throwable cause) {
		super(cause);
	}

}
