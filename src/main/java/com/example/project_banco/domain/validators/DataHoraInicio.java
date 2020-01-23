package com.example.project_banco.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DataHoraInicioValidator.class)
@Documented
public @interface DataHoraInicio {

    String message() default "Data de inicio inválida.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 