package com.backend.ContadorDeImpactos.controller;

import com.backend.ContadorDeImpactos.dtos.ContagemPayloadDTO;
import com.backend.ContadorDeImpactos.dtos.HistoricoRespostaDTO;
import com.backend.ContadorDeImpactos.entities.HistoricoTrafegoEntity;
import com.backend.ContadorDeImpactos.entities.PainelEntity;
import com.backend.ContadorDeImpactos.services.HistoricoTrafegoService;
import com.backend.ContadorDeImpactos.services.PainelService;

import jakarta.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrafegoController {

    @Autowired
    private HistoricoTrafegoService historicoTrafegoService;

    @Autowired 
    private PainelService painelService;

    @PostMapping("/contagem")
    @Transactional 
    public ResponseEntity<String> receberContagem(@RequestBody ContagemPayloadDTO payload) {
        try {
            System.out.println("## Payload recebido ##");
            System.out.println("Conteúdo do Payload: " + payload.toString());
            PainelEntity painel = painelService.encontrarPainelPorId(payload.getPainelId());
            HistoricoTrafegoEntity registro = new HistoricoTrafegoEntity();
            registro.preencherComDTO(payload);
            registro.setPainel(painel);
            historicoTrafegoService.salvar(registro);
            return ResponseEntity.ok("Registro de tráfego salvo com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao processar dados: " + e.getMessage());
        }
    }


    @GetMapping("/contagem")
    public ResponseEntity<?> listarHistorico(@RequestParam(required = false) String painelId) {
        try {
                HistoricoRespostaDTO resumo = historicoTrafegoService.obterResumoPorPainel(painelId);
                return ResponseEntity.ok(resumo);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao buscar histórico: " + e.getMessage());
        }
    }

}