package com.entregaindividual.ServicesImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entregaindividual.Model.Destino;
import com.entregaindividual.Model.Usuario;
import com.entregaindividual.Services.UsuarioServices;
import com.entregaindividual.repositories.DestinoRepository;
import com.entregaindividual.repositories.UsuarioRepository;





@Service
public  class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	private UsuarioRepository ur;
	

	private DestinoRepository dr;
	
	
	@Override
	public List<Usuario> GetAllUsuarios() {
		return ur.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		return ur.findById(id).orElseThrow(()-> new RuntimeException("Id:" + id + "not Found"));
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return ur.save(usuario);
	}
 
	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuario = ur.findById(id).orElseThrow(()-> new RuntimeException("Id:" + id + "not Found"));
		if (usuario != null) {
			usuario.setNome(usuarioAtualizado.getNome());
			usuario.setCpf(usuarioAtualizado.getCpf());
			usuario.setCelular(usuarioAtualizado.getCelular());
			usuario.setEmail(usuarioAtualizado.getEmail());
			usuario.setSenha(usuarioAtualizado.getSenha());
			usuario.setGenero(usuarioAtualizado.getGenero());
			return ur.save(usuario);
		}else {
			throw new RuntimeException("Usuario com o ID " + id + "não encontrado. ");
		}
		
	}

	@Override
	public void deleteUsuario(Long id) {
		
		ur.deleteById(id);
	}


	@Override
	public List<Objects> findAllRels() {
		
		return null;
	}

	@Override
	public void addRelationship(Long usuarioId, Long destinoId) {
		Usuario usuario = ur.findById(usuarioId).orElseThrow(() -> new RuntimeException("ID: " + usuarioId + "Not Found"));
		Destino destino = dr.findById(destinoId).orElseThrow(() -> new RuntimeException("ID: " + destinoId + "Not Found"));
		
		if(destino != null && usuario != null) {
			destino.getUsuarios().add(destino);
			usuario.getDestinos().add(destino);
			
			dr.save(destino);
			ur.save(usuario);
			
		}
		
	}
	
	}

	
	



	


  
    

