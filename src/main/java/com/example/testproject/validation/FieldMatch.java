package com.example.testproject.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldMatch {
    String message() default "This field must match.";
    String first() ;
    String second() ;
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List
    {
        FieldMatch[] value();
    }
}
