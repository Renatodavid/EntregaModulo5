package com.entregaindividual.DestinoDTO;

import java.math.BigDecimal;
import java.util.Date;



public class DestinoDTO {

	private Long id;

	private String nome_destino;
	
	private BigDecimal valor;
	
	private Date data_chegada;
	
	private Date data_saida;
	
	private String hora_chegada;

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
