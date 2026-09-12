package com.backend.ContadorDeImpactos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class PainelDTO {

    private String nomeDoPainel;
    private String enderecoDoPainel;
    private String cepDoPainel;
    private String cidadeDoPainel;
    private String estado;
    
}
