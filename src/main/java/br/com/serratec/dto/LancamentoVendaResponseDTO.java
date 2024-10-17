package br.com.serratec.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.entity.Vendedor;

public class LancamentoVendaResponseDTO {
	private LocalDate data;
	private Double valor;
	private Vendedor nomeVendedor;
	
	public LancamentoVendaResponseDTO(LancamentoVendas lancamentos) {
		
		this.data = lancamentos.getData();
		this.valor = lancamentos.getValor();
		this.nomeVendedor = lancamentos.getVendedor();
	}


	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Vendedor getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(Vendedor nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	
}
