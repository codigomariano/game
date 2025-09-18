package ar.com.codigomariano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.servicios.UserService;

@Controller
public class Home {
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String home() {
		Usuario u = new Usuario("dummy@hotmail.com");
		System.out.println(u.getId());
		this.service.guardarUsuario(u);
		System.out.println(u.getId());
		
		u = this.service.obtener(1l);
		
		return "home";
	}
}
