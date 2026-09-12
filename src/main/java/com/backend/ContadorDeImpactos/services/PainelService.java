package com.backend.ContadorDeImpactos.services;

import java.util.List;

import com.backend.ContadorDeImpactos.dtos.PainelDTO;
import com.backend.ContadorDeImpactos.entities.PainelEntity;

public interface PainelService {

    void salvar(PainelDTO painelDTO);
    PainelEntity encontrarPainelPorId(String id);
    List<PainelEntity> listarTodosOsPaineis();
    
}
