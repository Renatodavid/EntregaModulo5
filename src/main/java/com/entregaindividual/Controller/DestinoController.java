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

import com.entregaindividual.DestinoDTO.DestinoDTO;
import com.entregaindividual.Model.Destino;
import com.entregaindividual.Services.DestinoServices;
import com.entregaindividual.repositories.DestinoRepository;



@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoServices ds;
	
	@Autowired
	private DestinoRepository dr;
	
	@PostMapping("/savedestino")
	public Destino createDestino(@RequestBody Destino destinoDto) {
		
		
		
		return ds.saveDestino(destinoDto);
	}
	
	@GetMapping("/alldestinos")
	public List<Destino> getAllDestino(){
		
		return ds.GetAllDestino();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Destino>getDestinoById(@PathVariable Long id){
		Destino destino = ds.getDestinoById(id);
		
		return ResponseEntity.ok(destino);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Destino> uptadeDestino(@PathVariable Long destino_id, @RequestBody DestinoDTO destinoDTOUpdate){
		Destino destino = ds.getDestinoById(destino_id);
	
		ds.updateDestino(destino_id, destinoDTOUpdate);
		
		return ResponseEntity.ok(destino);
		
	}
	
	@DeleteMapping("/{destino_id}")
	public void deleteDestino(@PathVariable Long destino_id) {
		ds.deleteDestino(destino_id);
	}
}