package online.visa.center.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.visa.center.config.jwt.JwtTokenProvider;
import online.visa.center.model.User;
import online.visa.center.model.dto.AuthenticationReqDto;
import online.visa.center.service.UserService;

@RestController
@RequestMapping("/visa/center")
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;
	private UserService userService;

	@Autowired
	public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			UserService userService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@PostMapping(value = "/login")
	public ResponseEntity login(@RequestBody AuthenticationReqDto reqDto) {
		try {
			String username = reqDto.getUsername();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, reqDto.getPassword()));
			User user = userService.findUserByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("User with username: " + username + " not found");
			}
			String token = jwtTokenProvider.createToken(username);
			
			Map<Object, Object> response = new HashMap<>();
			response.put("username", username);
			response.put("token", token);
			
			return ResponseEntity.ok(response);
		} catch (AuthenticationException ex) {
			throw new BadCredentialsException("Invalid username or password");
		}

	}

}
