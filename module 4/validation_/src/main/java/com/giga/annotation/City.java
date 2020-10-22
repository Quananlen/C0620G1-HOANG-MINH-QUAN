package com.giga.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CityValidator.class)
@Documented
public @interface City {
    String message() default "City is not allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
