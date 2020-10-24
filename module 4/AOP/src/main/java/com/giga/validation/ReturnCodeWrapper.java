package com.giga.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReturnCodeWrapper {
    @NotNull
    @Range(min = 10000, max = 99999, message = "Code must have 5 digits")
    private Integer returnCode;
}
