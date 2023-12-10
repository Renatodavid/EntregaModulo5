package com.entregaindividual.Services;

import java.util.List;

import com.entregaindividual.Model.Usuario;

public interface UsuarioServices {

	List<Usuario>GetAllUsuarios();
	
	Usuario getUsuarioById( Long id);
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario( Long id, Usuario usuarioAtualizado);
	
	void deleteUsuario(Long id);
	
	
	
}
