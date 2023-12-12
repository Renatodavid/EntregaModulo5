package com.entregaindividual.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregaindividual.Model.Usuario;
import com.entregaindividual.Services.UsuarioServices;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	

	@Autowired
	private UsuarioServices us;
	
	@PostMapping("/saveusuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return us.saveUsuario(usuario);
	}
	
	@GetMapping("/allusuario")
	public List<Usuario> getAllUsuario(){
		return us.GetAllUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
		Usuario usuario = us.getUsuarioById(id);
		
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioUpdate){
		Usuario usuario = us.getUsuarioById(id);
		
		usuario.setUsuario_id(usuarioUpdate.getUsuario_id());
		usuario.setNome(usuarioUpdate.getNome());
		usuario.setCpf(usuarioUpdate.getCpf());
		usuario.setEmail(usuarioUpdate.getEmail());
		usuario.setCelular(usuarioUpdate.getCelular());
		usuario.setSenha(usuarioUpdate.getSenha());
		usuario.setGenero(usuarioUpdate.getGenero());
		
		return ResponseEntity.ok(usuario);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		us.deleteUsuario(id);
	}
}