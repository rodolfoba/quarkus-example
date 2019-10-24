package quarkus.example.feature.hello;


import quarkus.example.library.ExceptionChecker;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ExceptionChecker.isValid(() -> new Name(value));
    }
}
