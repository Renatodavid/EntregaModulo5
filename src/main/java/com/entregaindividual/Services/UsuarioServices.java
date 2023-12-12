package com.entregaindividual.Services;

import java.util.List;
import java.util.Objects;




import com.entregaindividual.Model.Usuario;


public interface UsuarioServices {

	List<Usuario>GetAllUsuarios();
	
	Usuario getUsuarioById( Long id);
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario( Long id, Usuario usuarioAtualizado);
	
	void deleteUsuario(Long id);

	void addRelationship(Long destinoId, Long usuarioId);

	List<Objects> findAllRels();

	


	
	
	
	
}
