package com.carlosmillan.springbootform.validators;

import com.carlosmillan.springbootform.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
        if(!usuario.getPhone().matches("60[1-9]{1}-[0-9]{7}")) {
            errors.rejectValue("phone", "Pattern.usuario.phone");
        }
    }
}