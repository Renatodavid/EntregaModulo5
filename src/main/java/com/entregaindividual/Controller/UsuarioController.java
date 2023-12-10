package com.entregaindividual.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entregaindividual.Model.Usuario;
import com.entregaindividual.Services.UsuarioServices;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	

	
	@Autowired
	private UsuarioServices UsuarioServices;
	

	
	//Home usuario
	@GetMapping("home/{id}")
	public String listaUsuario (@PathVariable Long id, Model model) {
		Usuario usuarioLocalizado = UsuarioServices.getUsuarioById(id);
		model.addAttribute("usuario", usuarioLocalizado);
		return"homeusuario";
	}
	
	//Visualizar destino 
	@GetMapping("/visualiar/{id}")
	public String visualizarCompra(Model model) {
		List<Usuario>localizarUsuario = UsuarioServices.GetAllUsuarios();
		model.addAttribute("usuario", localizarUsuario);
		return "visualizarCompra";
	}
	
	//perfil do usuario
	@GetMapping("/profile/{id}")
	public String perfilUsuario(@PathVariable Long id, Model model) {
		
		Usuario usuario = UsuarioServices.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		return "userprofile";
	}
	
	//formulario de cadastro
	
	public String formCadastroUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "cadastro";
	}
	
	
}
