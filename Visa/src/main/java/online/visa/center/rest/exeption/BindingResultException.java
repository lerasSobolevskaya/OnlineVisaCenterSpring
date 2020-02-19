package online.visa.center.rest.exeption;

import java.util.List;

import org.springframework.validation.ObjectError;

public class BindingResultException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private StringBuffer messages = new StringBuffer();

	public BindingResultException() {
	}

	public BindingResultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BindingResultException(String message, Throwable cause) {
		super(message, cause);
	}

	public BindingResultException(String message) {
		super(message);
	}

	public BindingResultException(Throwable cause) {
		super(cause);
	}

	public BindingResultException(List<ObjectError> objectErrors) {
		objectErrors.stream().map(error -> error.getDefaultMessage()).forEach(s -> messages.append(s));
	}

	@Override
	public String getMessage() {
		return messages.toString();
	}
}
