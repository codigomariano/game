package ar.com.codigomariano.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ar.com.codigomariano.api.rest.LoginAPIRestService;
import ar.com.codigomariano.config.filters.JWTAuthorizationFilter;
import ar.com.codigomariano.controllers.LoginController;
import ar.com.codigomariano.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private JWTAuthorizationFilter jwtFilter;

	
	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

		return http.securityMatcher("/api/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> request
					.requestMatchers(LoginAPIRestService.API_LOGIN_URL).permitAll()
					.anyRequest().authenticated())
			.csrf(csrt -> csrt.disable())
			.addFilterAfter(this.jwtFilter, BasicAuthenticationFilter.class)
			.build();

	}
	
	
	@Bean
	public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {

		return http.securityMatcher("/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/css/**", "/fonts/**", "/images/**", "/js/**").permitAll()
					  .requestMatchers("/signIn").permitAll()
					  .requestMatchers("/adm/users").hasRole(Permiso.ADMINISTRADOR.name())
					  .anyRequest().authenticated())
			.formLogin(page -> page.loginPage(LoginController.LOGIN_URL).permitAll()).build() ;	
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
	    return (request, response, accessDeniedException) -> {
	        response.sendRedirect(LoginController.LOGIN_URL);
	    };
	}
	
}
