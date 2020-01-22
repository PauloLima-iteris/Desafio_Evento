package com.example.project_banco.domain.dto.request;


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
public class ParticipacaoRequest {

    //@NotEmpty(message = "Id_Evento is required")
    private Integer IdEvento;

    @NotEmpty(message = "Login_Participante is required")
    @Size(min = 1, max =  255)
    private String LoginParticipante;

    //@NotEmpty(message = "Flag_Presente is required")
    private Boolean FlagPresente;
}
