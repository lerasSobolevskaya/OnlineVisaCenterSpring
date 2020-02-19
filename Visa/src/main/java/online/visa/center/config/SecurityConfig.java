package online.visa.center.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import online.visa.center.config.jwt.JwtConfigurer;
import online.visa.center.config.jwt.JwtTokenProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private JwtTokenProvider tokenProvider;

	@Autowired
	public SecurityConfig(JwtTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.POST, "/visa/center/login").permitAll()
				.antMatchers(HttpMethod.GET, "/visa/center/questionnaires").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/visa/center/questionnaires/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/visa/center/questionnaires").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.DELETE, "/visa/center/questionnaires/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/visa/center/questionnaires/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/visa/center/visas").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/visa/center/visas/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/visa/center/visas").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/visa/center/visas/{id}").hasAuthority("USER")
				.antMatchers(HttpMethod.GET, "/visa/center/users").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/visa/center/users/{id}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/visa/center/users").permitAll()
				.antMatchers(HttpMethod.PUT, "/visa/center/users/{id}").hasAuthority("USER")
				.antMatchers(HttpMethod.DELETE, "/visa/center/users/{id}").hasAuthority("USER").anyRequest()
				.authenticated().and().apply(new JwtConfigurer(tokenProvider));

	}

}
