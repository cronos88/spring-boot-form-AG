package com.carlosmillan.springbootform.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.carlosmillan.springbootform.models.domain.Usuario;

@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;

		ValidationUtils.rejectIfEmpty(errors, "password", "NotEmpty.usuario.password");

		if (usuario.getEmail().isEmpty()) {
			errors.rejectValue("email", "NotEmpty.usuario.email");
		} else if (!usuario.getEmail().contains("@")) {
			errors.rejectValue("email", "Email.usuario.email");
		}

		/*
		 * if(!usuario.getPhone().matches("60[1-9]{1}-[0-9]{7}")) {
		 * errors.rejectValue("phone", "Pattern.usuario.phone"); }
		 */
	}
}
