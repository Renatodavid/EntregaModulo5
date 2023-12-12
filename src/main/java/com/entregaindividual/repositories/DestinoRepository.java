package com.entregaindividual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entregaindividual.DestinoDTO.DestinoDTO;
import com.entregaindividual.Model.Destino;

import jakarta.transaction.Transactional;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true,value= "INSERT INTO destino VALUES (destino_id, data_chegada, data_saida"
			+ "hora_chegada , nome_destino, valor)")
	void addRelationShip(@Param("compra")Long nome_destino, @Param("usuario_id")Long usuario_id);
	
	
	@Query(nativeQuery = true, value = "SELECT  DISTINCT u.nome_usuario, d.nome_destino FROM"
	+"compra c INNER JOIN usuario u ON c.usuario_id = u.usuario_id INNER JOIN destino d ON d.destino_id = c.destino_id")
	
	List<Object> findAllRels();


	Destino save(DestinoDTO destinoDto);

}
