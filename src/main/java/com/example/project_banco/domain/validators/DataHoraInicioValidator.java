package com.example.project_banco.domain.validators;

import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DataHoraInicioValidator implements ConstraintValidator<DataHoraInicio, Date> {
    
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Date d = new Date();
        Long diaEvento = value.getTime();
        Long valor = diaEvento - d.getTime();

        if(valor <= 86400000){
            return false;
        }
        return true;
    }
}