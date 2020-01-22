package com.example.project_banco.domain.dto.request;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRequest {

    //@NotEmpty(message = "Id_Evento_Status is required")
    private Integer IdEventoStatus;

    //@NotEmpty(message = "Id_Categoria_Evento is required")
    private Integer IdCategoriaEvento;

    @NotEmpty(message = "Nome is required")
    @Size(min = 1, max =  255)
    private String Nome;

    //@NotEmpty(message = "Data_Hora_Inicio is required")
    private Date DataHoraInicio;

    //@NotEmpty(message = "Data_Hora_Fim is required")
    private Date DataHoraFim;

    @NotEmpty(message = "Local is required")
    @Size(min = 1, max =  255)
    private String Local;

    @NotEmpty(message = "Descricao is required")
    @Size(min = 1, max =  1000)
    private String Descricao;

    //@NotEmpty(message = "Limite_Vagas is required")
    private Integer LimiteVagas;
}
