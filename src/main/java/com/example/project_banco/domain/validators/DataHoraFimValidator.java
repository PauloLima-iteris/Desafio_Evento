package com.example.project_banco.domain.validators;

import java.util.Calendar;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.project_banco.domain.dto.request.EventoRequest;

public class DataHoraFimValidator implements ConstraintValidator<DataHoraFim, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();

        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());

        if((inicio.get(Calendar.DAY_OF_YEAR) == fim.get(Calendar.DAY_OF_YEAR)) && (inicio.get(Calendar.YEAR) == fim.get(Calendar.YEAR))){
            return true;
        }
        return false;
    }
}
