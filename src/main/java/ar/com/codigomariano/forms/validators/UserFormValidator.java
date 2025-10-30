package ar.com.codigomariano.forms.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.codigomariano.forms.UserForm;
import ar.com.codigomariano.servicios.UserService;

@Component
public class UserFormValidator implements Validator {
	@Autowired
	private UserService servicio;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm f = (UserForm) target;
		
		if(f.getEmail() == null || f.getEmail().isBlank()) {
			errors.rejectValue("email", "email.empty");
		} else {
			boolean exists = this.servicio.userExists(f.getEmail());
			if(exists) errors.rejectValue("email", "email.already.exists");
		}
	}

}
