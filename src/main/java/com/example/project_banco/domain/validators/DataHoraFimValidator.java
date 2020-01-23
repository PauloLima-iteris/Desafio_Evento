package com.example.project_banco.domain.validators;

import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.project_banco.domain.dto.request.EventoRequest;

public class DataHoraFimValidator implements ConstraintValidator<DataHoraInicio, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();

        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());

        if(inicio.get(Calendar.DAY_OF_YEAR) == fim.get(Calendar.DAY_OF_YEAR)){
            return true;
        }

        return false;
    
    }
    

}

// private Date after(Date d, Calendar c) {
//     Date after;
//     c.setTime(d);
//     c.add(Calendar.DATE, 7);
//     after = c.getTime();
//     System.out.println("Dia after" + after);
//     return after;
// }