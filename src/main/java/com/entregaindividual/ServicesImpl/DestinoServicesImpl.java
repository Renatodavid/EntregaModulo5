package com.entregaindividual.ServicesImpl;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entregaindividual.DestinoDTO.DestinoDTO;
import com.entregaindividual.Model.Destino;
import com.entregaindividual.Model.Usuario;
import com.entregaindividual.Services.DestinoServices;
import com.entregaindividual.repositories.DestinoRepository;
import com.entregaindividual.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class DestinoServicesImpl implements DestinoServices {

	
    @Autowired
    private DestinoRepository dr;

    @Autowired
    private UsuarioRepository ur;

    @Override
    public List<Destino> GetAllDestino() {
        return dr.findAll();
    }

 
    @Override
    public Destino saveDestino(Destino destinoDto) {
    	return dr.save(destinoDto);
    	
    	
    }
    
    @Override
    public Destino getDestinoById(Long destino_id) {
        return dr.findById(destino_id).orElseThrow(() -> new EntityNotFoundException("Destino com ID " + destino_id + " não encontrado."));
    }


    @Override
	public Destino updateDestino(Long destino_id, DestinoDTO destinoDTOUpdate) {
    	   Destino destinoExistente = dr.findById(destino_id).orElseThrow(() -> new EntityNotFoundException("Destino com ID " + destino_id + " não encontrado."));
           if (destinoExistente != null) {
               destinoExistente.setNome_destino(destinoDTOUpdate.getNome_destino());
               destinoExistente.setValor(destinoDTOUpdate.getValor());
               destinoExistente.setData_chegada(destinoDTOUpdate.getData_chegada());
               destinoExistente.setData_saida(destinoDTOUpdate.getData_saida());
               destinoExistente.setHora_chegada(destinoDTOUpdate.getHora_chegada());
               return dr.save(destinoExistente);
           } else {
               throw new RuntimeException("Destino com ID " + destino_id + " não foi possível localizar");
           }
       }
	
	
    @Override
    public void deleteDestino(Long destino_id) {
        dr.deleteById(destino_id);
    }

	
	@Override
	public void addRelationship(Long usuario_id, Long destino_id) {
		Usuario usuario = ur.findById(usuario_id).orElseThrow(() -> new RuntimeException("ID: " + usuario_id + "Not Found"));
		Destino destino = dr.findById(destino_id).orElseThrow(() -> new RuntimeException("ID: " + destino_id + "Not Found"));
		
		if(destino != null && usuario != null) {
			destino.getUsuarios().add(destino);
			usuario.getDestinos().add(destino);
			
			dr.save(destino);
			ur.save(usuario);
			
		}
		
	}
	@Override
	public List<Object> findAllRels() {
		
		return dr.findAllRels();
	}


	
}
