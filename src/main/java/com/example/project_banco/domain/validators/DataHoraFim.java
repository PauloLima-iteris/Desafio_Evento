package com.example.project_banco.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = DataHoraFimValidator.class)
@Documented
public @interface DataHoraFim {

    String message() default "Data de Fim em dia diferente de Inicio.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 