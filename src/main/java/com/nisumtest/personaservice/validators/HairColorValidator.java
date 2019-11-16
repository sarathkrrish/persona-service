package com.nisumtest.personaservice.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HairColorValidator implements ConstraintValidator<HairColor, String>{

	static final List<String> hairColors = Arrays.asList("black","yellow","red","brown","white");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return hairColors.contains(value);
	}

}
