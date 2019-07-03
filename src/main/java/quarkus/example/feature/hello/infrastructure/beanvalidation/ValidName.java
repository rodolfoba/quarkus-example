package quarkus.example.feature.hello.infrastructure.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidNameValidator.class)
public @interface ValidName {

    String message() default "Invalid name";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };


}
