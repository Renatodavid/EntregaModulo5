package com.entregaindividual.Services;

import java.util.List;

import com.entregaindividual.DestinoDTO.DestinoDTO;
import com.entregaindividual.Model.Destino;


public interface DestinoServices  {
	
	
	List<Destino>GetAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino destinoDto);
	
	Destino updateDestino(Long id, DestinoDTO destinoDTOUpdate);
	
	void deleteDestino(Long id);

	void addRelationship(Long usuario_id, Long destino_id);

	List<Object> findAllRels();

	

	

	
	
}
