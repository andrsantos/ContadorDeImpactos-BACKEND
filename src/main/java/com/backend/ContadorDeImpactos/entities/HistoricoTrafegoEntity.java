package com.backend.ContadorDeImpactos.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

import com.backend.ContadorDeImpactos.dtos.ContagemPayloadDTO;

@Entity
@Table(name = "historico_trafego")
@Data
public class HistoricoTrafegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private Integer totalMinuto;
    private Integer pedestres;
    private Integer carros;
    private Integer motos;
    private Integer onibus;
    private Integer caminhoes;

    public void preencherComDTO(ContagemPayloadDTO dto) {

        this.dataHora = LocalDateTime.ofInstant(
                Instant.ofEpochMilli((long) (dto.getTimestamp() * 1000)),
                ZoneId.systemDefault());
        this.totalMinuto = dto.getTotal_no_minuto_atual();

        Map<String, Integer> cls = dto.getClasses();
        this.pedestres = cls.getOrDefault("0", 0);
        this.carros = cls.getOrDefault("2", 0);
        this.motos = cls.getOrDefault("3", 0);
        this.onibus = cls.getOrDefault("5", 0);
        this.caminhoes = cls.getOrDefault("7", 0);
    }

}