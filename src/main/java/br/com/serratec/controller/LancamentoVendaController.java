package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendaResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendaController {
	
	@Autowired
	private LancamentoService service;
	
	@GetMapping("/paginacao")
	public Page<LancamentoVendas> listar(@PageableDefault(page = 0, size = 10,
	sort = "valor", direction = Direction.ASC) Pageable pageable) {
		return service.listarPorPagina(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LancamentoVendaResponseDTO> listarPorId(@PathVariable Long id){
		LancamentoVendaResponseDTO lancamentoDTO = service.listarPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoDTO);
	}
	
	
	
}
