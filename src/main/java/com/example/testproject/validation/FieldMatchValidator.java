package com.example.testproject.validation;


import com.example.testproject.dto.UserForm;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, UserForm> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
         this.firstFieldName    = constraintAnnotation.first();
         this.secondFieldName   = constraintAnnotation.second();
         this.message           = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserForm value, ConstraintValidatorContext context) {
       String pass = value.getPassword();
       String Confirmpass = value.getConfirmPassword();
        return pass.equals(Confirmpass);

    }
}
