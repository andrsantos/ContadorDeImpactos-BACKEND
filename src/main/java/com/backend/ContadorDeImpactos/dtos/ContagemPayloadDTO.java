package com.backend.ContadorDeImpactos.dtos;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ContagemPayloadDTO {
    
    private Integer total_acumulado_geral;
    private Integer total_no_minuto_atual;
    private Map<String, Integer> classes;
    private Double timestamp;


}