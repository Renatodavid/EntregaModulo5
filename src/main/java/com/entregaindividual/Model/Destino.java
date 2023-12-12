package com.entregaindividual.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table (name ="destino")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long destino_id;
	
	@Column( length = 100 )
	private String nome_destino;
	
	@Column(length = 50 )
	private BigDecimal valor;
	
	@Column(name = "data_chegada")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_chegada;
	
	@Column(name = "data_saida")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_saida;
	
	@Column(columnDefinition = "TEXT")
	private String hora_chegada;

	
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "compra",
joinColumns = @JoinColumn(name = "nome_destino"),
inverseJoinColumns = @JoinColumn(name = "usuario_id"))
private Set<Usuario> usuarios = new HashSet<>();

	public Destino () {
		super();
}


	public Long getDestino_id() {
		return destino_id;
	}


	public void setDestino_id(Long destino_id) {
		this.destino_id = destino_id;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public String getNome_destino() {
		return nome_destino;
	}

	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(Date data_chegada) {
		this.data_chegada = data_chegada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public String getHora_chegada() {
		return hora_chegada;
	}

	public void setHora_chegada(String hora_chegada) {
		this.hora_chegada = hora_chegada;
	}

	
	public List<Destino> getUsuarios() {
		
		return null;
	}

	public List<Destino> getDestinos() {
		
		return null;
	}
	
	
	
}