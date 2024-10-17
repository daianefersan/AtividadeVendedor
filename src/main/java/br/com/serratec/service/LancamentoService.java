package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendaResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public LancamentoVendas listarPorId(Long id) {
		return repository.findById(id).orElseThrow
				(() -> new EntityNotFoundException("Lançamento não existente"));
	}
	
	public LancamentoVendas inserirLancamento(LancamentoVendas lancamento) {
		return repository.save(lancamento);
	}

	public Page<LancamentoVendas> listarPorPagina(Pageable pageable) {	
			return repository.findAll(pageable);
	}
	
	public List<LancamentoVendaResponseDTO> listar(){
		List<LancamentoVendas> lancamentos = repository.findAll();
		List<LancamentoVendaResponseDTO> dtos = new ArrayList<>();
		for (LancamentoVendas lancamento : lancamentos) {
			dtos.add(new LancamentoVendaResponseDTO(lancamento));
		}
		return dtos;
	}
}

