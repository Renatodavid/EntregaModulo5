package com.entregaindividual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entregaindividual.Model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
