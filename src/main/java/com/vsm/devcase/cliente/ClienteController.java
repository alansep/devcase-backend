package com.vsm.devcase.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabriel Alan Classe de endpoints referente aos clientes.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * Método que tem como função buscar todos os clientes e retorná-los paginados.
	 * 
	 * @param pageable
	 * @return ResponseEntity<?>
	 */
	@GetMapping
	public ResponseEntity<?> buscarTodosOsClientes(Pageable pageable) {

		Page<Cliente> clientes = clienteService.buscarTodosOsClientes(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	/**
	 * Método que tem como função buscar um cliente pelo seu código.
	 * 
	 * @param codigo
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarUmCliente(@PathVariable Integer codigo) {
		Cliente cliente = clienteService.buscarCliente(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	/**
	 * Método que tem como função cadastrar um novo cliente ao sistema.
	 * 
	 * @param cliente
	 * @return ResponseEntity<?>
	 */
	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
		Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}

	/**
	 * Método que tem como função atualizar um cliente.
	 * 
	 * @param cliente
	 * @param codigo
	 * @return ResponseEntity<?>
	 */
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizarCliente(@RequestBody @Valid Cliente cliente, @PathVariable Integer codigo) {
		Cliente clienteAtualizado = clienteService.atualizarCliente(codigo, cliente);
		return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
	}

}
