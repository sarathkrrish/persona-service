package com.nisumtest.personaservice.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HairColorValidator.class)
public @interface HairColor {
    String message() default "{persona.hair.validcolor}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}