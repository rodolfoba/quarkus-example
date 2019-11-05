package quarkus.example.feature.list;

import quarkus.example.feature.list.ItemListName;
import quarkus.example.feature.list.ValidItemListName;
import quarkus.example.library.ExceptionChecker;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidItemListNameValidator implements ConstraintValidator<ValidItemListName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ExceptionChecker.isValid(() -> new ItemListName(value));
    }
}
