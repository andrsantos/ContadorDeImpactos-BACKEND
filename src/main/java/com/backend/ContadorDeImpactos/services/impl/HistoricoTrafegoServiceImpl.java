package com.backend.ContadorDeImpactos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ContadorDeImpactos.dtos.HistoricoRespostaDTO;
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

    @Override
    public HistoricoRespostaDTO obterResumoPorPainel(String painelId) {

        List<HistoricoTrafegoEntity> listaHistorico = historicoTrafegoRepository.findByPainelIdOrderByIdDesc(painelId);
 
        if (listaHistorico == null || listaHistorico.isEmpty()) {
            throw new RuntimeException("O Painel não existe ou não possui histórico.");
        }

        
        HistoricoRespostaDTO dto = new HistoricoRespostaDTO();
        Integer totalCarros = 0;
        Integer totalOnibus = 0;
        Integer totalMotos = 0;
        Integer totalPedestres = 0;
        Integer totalCaminhoes = 0;

        for(int i = 0; i < listaHistorico.size(); i++){
            totalCarros += listaHistorico.get(i).getCarros();
            totalOnibus += listaHistorico.get(i).getOnibus();
            totalMotos += listaHistorico.get(i).getMotos();
            totalPedestres += listaHistorico.get(i).getPedestres();
            totalCaminhoes += listaHistorico.get(i).getCaminhoes();
        }

        Integer totalizacao = totalCaminhoes + totalCarros + totalOnibus + totalMotos + totalPedestres;

        dto.setCarros(totalCarros);
        dto.setVeiculosPesados(totalCaminhoes + totalOnibus);
        dto.setMotos(totalMotos);
        dto.setPedestres(totalPedestres);
        dto.setTotalImpactos(totalizacao);
        dto.setPainelId(painelId);
        
        return dto;
   
    }
    
    
}
