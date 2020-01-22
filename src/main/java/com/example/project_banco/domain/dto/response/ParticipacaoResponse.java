package com.example.project_banco.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    private int IdParticipacao;

    private int IdEvento;

    private String LoginParticipante;

    private Boolean FlagPresente;

    private int Nota;

    private String Comentario;

}
