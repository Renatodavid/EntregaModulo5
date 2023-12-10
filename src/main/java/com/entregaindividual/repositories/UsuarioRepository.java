package com.entregaindividual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entregaindividual.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//	Optional<Usuario> findByEmail(String email);
	
}
