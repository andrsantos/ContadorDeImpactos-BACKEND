package com.backend.ContadorDeImpactos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ContadorDeImpactos.entities.PainelEntity;

@Repository 
public interface PainelRepository extends  JpaRepository<PainelEntity, String>{
    
}
