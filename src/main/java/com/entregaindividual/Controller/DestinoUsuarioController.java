package com.entregaindividual.Controller;


import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregaindividual.DestinoDTO.DestinoUsuarioDTO;
import com.entregaindividual.Services.UsuarioServices;

@RestController
@RequestMapping("/destinousuario")
public class DestinoUsuarioController {

    @Autowired
    private UsuarioServices us;

    @PostMapping("/adddestinousuario")
    public ResponseEntity<String> addRelationship(@RequestBody DestinoUsuarioDTO usDTO) {
        us.addRelationship(usDTO.getDestinoId(), usDTO.getUsuarioId());

        return new ResponseEntity<>("Relationship created", HttpStatus.CREATED);
    }
    
    @GetMapping("/findallrels")
    public List<Objects> getAllRels(){
    	
    	return us.findAllRels();
    }
}
