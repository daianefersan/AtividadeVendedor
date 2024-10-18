package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendaRequestDTO;
import br.com.serratec.dto.LancamentoVendaResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendaController {
	
	@Autowired
	private LancamentoService service;
	
	@Operation(summary = "Lista de paginação de todas as vendas", description = "Venda com data, valor, e nome do vendedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200",
			description = "Retorna todas as vendas"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@GetMapping("/paginacao")
	public Page<LancamentoVendas> listar(@PageableDefault(page = 0, size = 10,
	sort = "valor", direction = Direction.ASC) Pageable pageable) {
		return service.listarPorPagina(pageable);
	}
	
	@Operation(summary = "Lista de lançamentos de vendas", description = "Venda com data, valor, e nome do vendedor a partir do id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200",
			description = "Retorna todas as vendas a partir "),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@GetMapping("/{id}")
	public ResponseEntity<LancamentoVendaResponseDTO> listarPorId(@PathVariable Long id){
		LancamentoVendaResponseDTO lancamentoDTO = service.listarPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoDTO);
	}
	
	@GetMapping
	public List<LancamentoVendaResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Insere um novo lançamento de vendas", description = "A resposta retorna a data, o valor e o nome do vendedor.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201",
			description = "Vendas lançadas com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping
	public ResponseEntity<LancamentoVendaResponseDTO> inserirLancamento(@RequestBody LancamentoVendaRequestDTO dto) {
        LancamentoVendaResponseDTO lancamentovendas = service.inserirlancamento(dto);
        return new ResponseEntity<>(lancamentovendas, HttpStatus.CREATED); 
    }

}
