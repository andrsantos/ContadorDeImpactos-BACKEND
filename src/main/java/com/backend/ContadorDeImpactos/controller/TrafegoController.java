package com.backend.ContadorDeImpactos.controller;

import com.backend.ContadorDeImpactos.dtos.ContagemPayloadDTO;
import com.backend.ContadorDeImpactos.entities.HistoricoTrafegoEntity;
import com.backend.ContadorDeImpactos.services.HistoricoTrafegoService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrafegoController {

    @Autowired
    private HistoricoTrafegoService historicoTrafegoService;

    @PostMapping("/contagem")
    @Transactional 
    public ResponseEntity<String> receberContagem(@RequestBody ContagemPayloadDTO payload) {
        try {
            System.out.println("## Payload recebido ##");
            HistoricoTrafegoEntity registro = new HistoricoTrafegoEntity();
            registro.preencherComDTO(payload);
            historicoTrafegoService.salvar(registro);
            return ResponseEntity.ok("Registro de tráfego salvo com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao processar dados: " + e.getMessage());
        }
    }
}