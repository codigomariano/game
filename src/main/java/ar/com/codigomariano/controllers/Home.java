package ar.com.codigomariano.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.codigomariano.forms.MessageForm;

@Controller
public class Home {
	public static final String HOME_URL = "/home";
	
	@GetMapping("/")
	public String home() {		
		return "redirect:" + "/login";
	}
	
	@GetMapping(HOME_URL)
	public String init(Model model) {
		model.addAttribute("msgForm", new MessageForm());
		
		return "home";
	}
}
