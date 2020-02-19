package online.visa.center.config.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 3776072252225710892L;

	public JwtAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public JwtAuthenticationException(String msg) {
		super(msg);
	}

}
