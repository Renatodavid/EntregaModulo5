package com.entregaindividual.Services;

import java.util.List;

import com.entregaindividual.Model.Destino;


public interface DestinoServices  {
	
	
	List<Destino>GetAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino destino);
	
	Destino updateDestino(Long id, Destino destinoAtt);
	
	void deleteDestino(Long id);

	

	

	
	
}
