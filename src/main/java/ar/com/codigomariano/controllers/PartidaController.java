package ar.com.codigomariano.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.codigomariano.forms.UserForm;

@Controller
public class PartidaController {
	private final String PATH = "/partidas";
	
	@GetMapping("/partida/init")
	public String init(Model model) {
		model.addAttribute("form", new UserForm());
		return PATH +"/init";
	}
}
