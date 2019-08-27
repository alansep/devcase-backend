package com.vsm.devcase.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<?> buscarTodosOsClientes(Pageable pageable) {

		Page<Cliente> clientes = clienteService.buscarTodosOsClientes(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarUmCliente(@PathVariable Integer codigo) {
		Cliente cliente = clienteService.buscarCliente(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
		Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizarCliente(@RequestBody @Valid Cliente cliente, @PathVariable Integer codigo) {
		Cliente clienteAtualizado = clienteService.atualizarCliente(codigo, cliente);
		return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable Integer codigo) {
		clienteService.removerCliente(codigo);
	}
}
