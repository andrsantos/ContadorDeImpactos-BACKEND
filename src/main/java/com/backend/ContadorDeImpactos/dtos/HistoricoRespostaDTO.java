package com.backend.ContadorDeImpactos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 

public class HistoricoRespostaDTO {
    private String painelId;
    private Integer totalImpactos;
    private Integer carros;
    private Integer pedestres;
    private Integer veiculosPesados;
    private Integer motos;    
}