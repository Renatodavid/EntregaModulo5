package com.entregaindividual.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private Long id;
	
	@Column(nullable = false, length = 100 , unique = true)
	private String nome_destino;
	
	@Column(nullable = false, length = 50 )
	private BigDecimal valor;
	
	@Column(name = "data_chegada")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_chegada;
	
	@Column(name = "data_saida")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_saida;
	
	@Column(columnDefinition = "TEXT")
	private String hora_chegada;

	
@ManyToMany
@JoinTable(name = "id",
joinColumns = @JoinColumn(name = "nome_destino"),
inverseJoinColumns = @JoinColumn(name = "usuario_id"))
private Set<Usuario> usuarios = new HashSet<>();

	public Destino () {
		super();
}

	public Destino(Long id, String nome_destino, BigDecimal valor, Date data_chegada, Date data_saida,
			String hora_chegada) {
		super();
		this.id = id;
		this.nome_destino = nome_destino;
		this.valor = valor;
		this.data_chegada = data_chegada;
		this.data_saida = data_saida;
		this.hora_chegada = hora_chegada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
}