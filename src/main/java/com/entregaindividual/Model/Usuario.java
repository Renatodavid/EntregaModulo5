package com.entregaindividual.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length = 200)
	private String nome;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

	@Column (nullable = false, length = 200 , unique = true)
	private String email;

	@Column (nullable = false, length = 16)
	private String celular;
	
	@Column(nullable = false,length = 200)
	private String senha;
	
	@Column (nullable = true != false)
	private boolean genero;

	
	@ManyToMany(mappedBy = "usuarios")
	private Set<Destino> destinos = new HashSet<>();
	
	public Usuario() {
		super();
	}
	
public Usuario(Long id, String nome, String cpf, String email, String celular, String senha, boolean genero) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.celular = celular;
	this.senha = senha;
	this.genero = genero;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCelular() {
	return celular;
}

public void setCelular(String celular) {
	this.celular = celular;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public boolean isGenero() {
	return genero;
}

public Set<Destino> getDestinos() {
	return destinos;
}

public void setDestinos(Set<Destino> destinos) {
	this.destinos = destinos;
}

public void setGenero(boolean genero) {
	this.genero = genero;
}



	
}