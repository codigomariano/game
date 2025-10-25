package ar.com.codigomariano.forms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.codigomariano.forms.UserForm;

@Component
public class UserFormValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm f = (UserForm) target;
		
		if(f.getEmail() == null || f.getEmail().isBlank()) {
			errors.rejectValue("email", "email.empty");
		}
	}

}
