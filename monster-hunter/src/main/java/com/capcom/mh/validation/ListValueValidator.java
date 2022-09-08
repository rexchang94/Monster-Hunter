package com.capcom.mh.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ListValueValidator implements ConstraintValidator<ListValue, String> {

    private Set<String> valueList;

    @Override
    public void initialize(ListValue constraintAnnotation) {
        valueList = new HashSet<>();
        valueList.addAll(Arrays.asList(constraintAnnotation.value()));
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return true;
        }

        return valueList.contains(s);
    }
}
