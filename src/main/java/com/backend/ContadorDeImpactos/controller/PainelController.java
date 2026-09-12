package com.backend.ContadorDeImpactos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.ContadorDeImpactos.dtos.PainelDTO;
import com.backend.ContadorDeImpactos.services.PainelService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/painel")
public class PainelController {

    @Autowired 
    private PainelService painelService;

    @PostMapping("/salvar")
    @Transactional 
    public ResponseEntity<String> criarPainel(@RequestBody PainelDTO painelDTO) {
        try {
            System.out.println("## Painel recebido ##");
            painelService.salvar(painelDTO);
            return ResponseEntity.ok("Registro de painel salvo com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao processar dados: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            return ResponseEntity.ok(painelService.listarTodosOsPaineis());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao listar painéis: " + e.getMessage());
        }
    }
    
}
