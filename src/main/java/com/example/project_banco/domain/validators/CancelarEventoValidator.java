package com.example.project_banco.domain.validators;

import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.project_banco.domain.dto.request.EventoRequest;

public class CancelarEventoValidator implements ConstraintValidator<DataHoraFim, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Calendar diaEvento = Calendar.getInstance();
        Calendar deletarEvento = Calendar.getInstance();

        diaEvento.setTime(value.getDataHoraInicio());
        deletarEvento.setTime(new Date());

        if((diaEvento.get(Calendar.DAY_OF_YEAR) != deletarEvento.get(Calendar.DAY_OF_YEAR)) && (diaEvento.get(Calendar.YEAR) != deletarEvento.get(Calendar.YEAR))){
            return true;
        }
        return false;
    }
}
