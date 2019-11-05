package quarkus.example.feature.list;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidItemListNameValidator.class)
public @interface ValidItemListName {

    String message() default "Invalid item list name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
