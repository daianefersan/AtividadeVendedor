package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.LancamentoVendas;

public class LancamentoVendaRequestDTO {

	private LocalDate data;
	private Double valor;
	private Long idVendedor;
	
	public LancamentoVendaRequestDTO(LancamentoVendas lancamentos) {
		super();
		this.data = lancamentos.getData();
		this.valor = lancamentos.getValor();
		this.idVendedor = lancamentos.getVendedor().getId() ;
	}
	
	public LancamentoVendaRequestDTO() {
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
	
	public Long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

}
