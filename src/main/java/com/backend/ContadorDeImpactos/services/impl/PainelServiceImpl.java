package com.backend.ContadorDeImpactos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ContadorDeImpactos.dtos.PainelDTO;
import com.backend.ContadorDeImpactos.entities.PainelEntity;
import com.backend.ContadorDeImpactos.repositories.PainelRepository;
import com.backend.ContadorDeImpactos.services.PainelService;

@Service 
public class PainelServiceImpl implements PainelService {

    @Autowired 
    private PainelRepository painelRepository;

    @Override
    public void salvar(PainelDTO painelDTO) {
        PainelEntity painelEntity = new PainelEntity();
        painelEntity.setCepDoPainel(painelDTO.getCepDoPainel());
        painelEntity.setCidadeDoPainel(painelDTO.getCidadeDoPainel());
        painelEntity.setEnderecoDoPainel(painelDTO.getEnderecoDoPainel());
        painelEntity.setEstado(painelDTO.getEstado());
        painelEntity.setNomeDoPainel(painelDTO.getNomeDoPainel());
        painelRepository.save(painelEntity);
    }

    @Override
    public PainelEntity encontrarPainelPorId(String id) {
        PainelEntity painel = painelRepository.findById(id).orElseThrow(() -> new RuntimeException("Painel não encontrado com o ID: " + id));
        return painel;
    }

    @Override
    public List<PainelEntity> listarTodosOsPaineis() {
        List<PainelEntity> listaDePaineis = painelRepository.findAll();
        return listaDePaineis;
    }
    
}
