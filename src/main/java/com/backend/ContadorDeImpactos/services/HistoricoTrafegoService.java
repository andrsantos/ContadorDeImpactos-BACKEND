package com.backend.ContadorDeImpactos.services;



import com.backend.ContadorDeImpactos.dtos.HistoricoRespostaDTO;
import com.backend.ContadorDeImpactos.entities.HistoricoTrafegoEntity;

public interface HistoricoTrafegoService {

    void salvar(HistoricoTrafegoEntity historicoTrafego);
    HistoricoRespostaDTO obterResumoPorPainel(String painelId);

    
}
