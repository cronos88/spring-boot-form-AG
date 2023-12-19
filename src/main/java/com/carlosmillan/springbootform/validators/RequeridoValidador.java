package com.carlosmillan.springbootform.validators;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// if(value == null || value.isEmpty() || value.isBlank()) {
		if (value == null || !StringUtils.hasText(value)) { // org.springframework.util.StringUtils
			return false;
		}
		return true;
	}
}
