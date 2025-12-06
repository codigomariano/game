package ar.com.codigomariano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import ar.com.codigomariano.controllers.LoginController;
import ar.com.codigomariano.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.formLogin(page -> page.loginPage(LoginController.LOGIN_URL).permitAll());
		
		return http.authorizeHttpRequests(auth -> auth.requestMatchers("/css/**", "/fonts/**", "/images/**", "/js/**").permitAll()
													  .requestMatchers("/signIn").permitAll()
													  .requestMatchers("/adm/users").hasRole(Permiso.ADMINISTRADOR.name())
													  .anyRequest().permitAll()).build();
		
	}
}
