package com.entregaindividual.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entregaindividual.Model.Usuario;
import com.entregaindividual.Services.UsuarioServices;
import com.entregaindividual.repositories.UsuarioRepository;





@Service
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> GetAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Id:" + id + "not Found"));
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Id:" + id + "not Found"));
		if (usuarioExistente != null) {
			usuarioExistente.setNome(usuarioAtualizado.getNome());
			usuarioExistente.setCpf(usuarioAtualizado.getCpf());
			usuarioExistente.setCelular(usuarioAtualizado.getCelular());
			usuarioExistente.setEmail(usuarioAtualizado.getEmail());
			usuarioExistente.setSenha(usuarioAtualizado.getSenha());
			usuarioExistente.setGenero(usuarioAtualizado.isGenero());
			return usuarioRepository.save(usuarioExistente);
		}else {
			throw new RuntimeException("Usuario com o ID " + id + "não encontrado. ");
		}
		
	}

	@Override
	public void deleteUsuario(Long id) {
		
		usuarioRepository.deleteById(id);
	}

}
