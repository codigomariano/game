package ar.com.codigomariano.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codigomariano.dtos.UsuarioDTO;
import ar.com.codigomariano.forms.UserForm;
import ar.com.codigomariano.servicios.UserService;

@RestController
public class UserAPIRestService {
	public static final String URL_PATH = "/api";
	public static final String API_USERS_URL_PATH = URL_PATH + "/users";
	public static final String API_SAVE_USER_URL_PATH = URL_PATH + "/users/save";
	
	@Autowired
	private UserService service;
	
	
	@GetMapping(value = API_USERS_URL_PATH,  
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioDTO>> list() {
		List<UsuarioDTO> usuarios = this.service.listAll();
		
		return ResponseEntity.ok(usuarios);
	}
	
	
	@PostMapping(value = API_SAVE_USER_URL_PATH, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody UserForm formulario) {
		
		formulario.getEmail();
		
		return ResponseEntity.ok("Todo Ok");
	}
}
