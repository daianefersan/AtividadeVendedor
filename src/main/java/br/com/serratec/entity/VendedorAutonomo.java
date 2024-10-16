package br.com.serratec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class VendedorAutonomo extends Vendedor{
	@Column
	private Double comissao;

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	
}
