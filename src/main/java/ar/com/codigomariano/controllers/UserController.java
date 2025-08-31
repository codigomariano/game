package ar.com.codigomariano.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	private final String PATH = "/users";


	@GetMapping("/usr/edit")
	public String edit(Model model) {
		model.addAttribute("form", null);
		return PATH + "/userFrm";
	}
}
