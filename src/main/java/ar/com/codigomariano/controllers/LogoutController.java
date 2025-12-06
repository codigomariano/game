package ar.com.codigomariano.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextHolder.clearContext();
		request.getSession().getAttribute("prueba");
		return "redirect:" + LoginController.LOGIN_URL;
	}
}
