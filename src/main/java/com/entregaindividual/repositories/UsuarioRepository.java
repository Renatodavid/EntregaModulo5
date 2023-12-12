package com.entregaindividual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entregaindividual.Model.Destino;
import com.entregaindividual.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	void save(Destino usuario);

	
}
