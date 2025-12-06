package ar.com.codigomariano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.forms.LoginForm;
import ar.com.codigomariano.forms.validators.LoginFormValidator;
import ar.com.codigomariano.servicios.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	public final static String LOGIN_URL = "/login";
	private static final String FORM_ATTRIBUTE = "form";
	@Autowired
	private UserService service;
	@Autowired
	private LoginFormValidator validator;
	
	@InitBinder(value = FORM_ATTRIBUTE)
	void initFormValidator(WebDataBinder binder) {
		binder.addValidators(this.validator);
	}
	
	
	@GetMapping(LOGIN_URL)
	public String login(Model model) {
		model.addAttribute(FORM_ATTRIBUTE, new LoginForm());
		
		return "unsecured/login";
	}
	
	
	@PostMapping("/signIn")
	public String signIn(HttpSession session, @Validated @ModelAttribute(name = FORM_ATTRIBUTE) LoginForm formulario, BindingResult resultados) {
		Usuario usuario = this.service.obtener(formulario.getEmail());
		
		SecurityContext contexto = SecurityContextHolder.getContext();
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(formulario.getEmail(), formulario.getEmail(), usuario.collectAuthorities());

		contexto.setAuthentication(authentication);
		
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, contexto);

		return "redirect:" + Home.HOME_URL;
	}
}
