package com.example.testproject.validation;

import com.example.testproject.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userRepo.existsByEmail(email);
    }
}
