
package com.endpointprodutos.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
