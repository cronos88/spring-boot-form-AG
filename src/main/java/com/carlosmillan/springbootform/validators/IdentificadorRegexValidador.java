package com.carlosmillan.springbootform.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("60[1-9]{1}-[0-9]{7}")) {
			return true;
		}
		return false;
	}
}
