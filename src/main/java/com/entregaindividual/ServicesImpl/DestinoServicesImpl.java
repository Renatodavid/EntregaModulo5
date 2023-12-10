package com.entregaindividual.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entregaindividual.Model.Destino;
import com.entregaindividual.Services.DestinoServices;
import com.entregaindividual.repositories.DestinoRepository;



@Service
public  class DestinoServicesImpl implements DestinoServices {
	
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public List<Destino> GetAllDestino() {
		return destinoRepository.findAll();
	}

	@Override
	public Destino getDestinoById(Long id) {
		
		return destinoRepository.findById(id).orElse(null);
	}

	

	
	@Override
	@Transactional(readOnly = true)
	public Destino saveDestino(Destino destino) {
		return destinoRepository.save(destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino destinoAtt) {
		Destino destinoExistente = destinoRepository.findById(id).orElse(null);
		if(destinoExistente != null) {
			destinoExistente.setNome_destino(destinoAtt.getNome_destino());
			destinoExistente.setValor(destinoAtt.getValor());
			destinoExistente.setData_chegada(destinoAtt.getData_chegada());
			destinoExistente.setData_saida(destinoAtt.getData_saida());
			destinoExistente.setHora_chegada(destinoAtt.getHora_chegada());
			return destinoRepository.save(destinoExistente);
		}else {
			throw new RuntimeException("Destino com ID " + id + "não foi possivel localiar");
			
		}
	
	}

	@Override
	public void deleteDestino(Long id) {
		destinoRepository.deleteById(id);
		
	}


	

	

	
	
	
}
