package com.backend.ContadorDeImpactos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ContadorDeImpactos.entities.HistoricoTrafegoEntity;
import com.backend.ContadorDeImpactos.repositories.HistoricoTrafegoRepository;
import com.backend.ContadorDeImpactos.services.HistoricoTrafegoService;

@Service 
public class HistoricoTrafegoServiceImpl implements HistoricoTrafegoService {

    @Autowired 
    private HistoricoTrafegoRepository historicoTrafegoRepository;

    @Override
    public void salvar(HistoricoTrafegoEntity historicoTrafego) {
      historicoTrafegoRepository.save(historicoTrafego);
    }
    
}
