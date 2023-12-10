package com.entregaindividual.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entregaindividual.Model.Destino;
import com.entregaindividual.Services.DestinoServices;


@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoServices destinoServices;

	@GetMapping
	public String listDestino(Model model) {
	    List<Destino> destino = destinoServices.GetAllDestino();
	    model.addAttribute("destino", destino);
	    return "ListarDestino";
	}

	// Formulário de criação
	@GetMapping("/form")
	public String formAdd(Model model) {
	    Destino destino = new Destino();
	    model.addAttribute("destino", destino);
	    return "destinoForm";
	}

	
	//persistencia de criação
	@PostMapping ("/save")
	public String saveDestino(@ModelAttribute Destino destino) {
		destinoServices.saveDestino(destino);
		return "redirect:/destinos";
	}
	
	//formulario de edição
	@PostMapping("editar/{id}")
	public String FormUpdate(@PathVariable Long id, Model model) {
		Destino destino = destinoServices.getDestinoById(id);
		model.addAttribute("destino", destino);
		return "editarDestino";
	}
	
	//persistencia da edição
	@PutMapping("/editar/{id}")
	public String updateDestino(@PathVariable Long id, @ModelAttribute
	Destino destino) {
		destinoServices.updateDestino(id, destino);
		return "redirect:/destinos";
	}
	//excluir destino
	@GetMapping("/deletar/{id}")
	public String deleteDestino(@PathVariable Long id) {
		destinoServices.deleteDestino(id);
		return "redirect:/destino";
	}
}
