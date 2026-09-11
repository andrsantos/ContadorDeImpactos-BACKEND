package com.backend.ContadorDeImpactos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ContadorDeImpactos.entities.HistoricoTrafegoEntity;

@Repository 
public interface HistoricoTrafegoRepository extends JpaRepository<HistoricoTrafegoEntity, String> {
    
}
