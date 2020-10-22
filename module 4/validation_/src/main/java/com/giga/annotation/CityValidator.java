package com.giga.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CityValidator implements ConstraintValidator<City, String> {
    List<String> cities = Arrays.asList("Sai Gon", "Ha Noi", "Da Nang", "Hue", "Quang Nam");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return cities.contains(value);
    }
}