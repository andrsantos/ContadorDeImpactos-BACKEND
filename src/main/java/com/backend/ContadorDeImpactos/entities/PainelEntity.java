package com.backend.ContadorDeImpactos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "tb_paineis")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class PainelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nomeDoPainel;
    private String enderecoDoPainel;
    private String cepDoPainel;
    private String cidadeDoPainel;
    private String estado;
    
}
