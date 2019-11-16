package com.nisumtest.personaservice.domain;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nisumtest.personaservice.validators.HairColor;

import lombok.Data;

@Data
public class Persona {
	
	@NotNull
	@Min(value = 1)
	Integer id;
	
	
	@NotEmpty
	String name;
	
	
	@NotEmpty
	String lastName;
	
	
	@Pattern(regexp = "[a-zA-Z\\d ]+")
	String address;
	
	@NotEmpty
	@Pattern(regexp = "\\d+")
	@Size(min = 10, max = 10)
	String mobileNumber;
	
	@HairColor
	String hairColor;
	
	
	
}
