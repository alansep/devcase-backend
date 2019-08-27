package com.vsm.devcase.cliente;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired	
	private ClienteRepository clienteRepository;

	public Page<Cliente> buscarTodosOsClientes(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public Cliente cadastrarCliente(Cliente cliente) {
		cliente.setPontuacao(0);
		return clienteRepository.save(cliente);
	}

	public Cliente buscarCliente(Integer codigo) {
		Cliente cliente = clienteRepository.findOne(codigo);
		return cliente;
	}

	public Cliente atualizarCliente(Integer codigo,  Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.findOne(codigo);
		BeanUtils.copyProperties(cliente, clienteSalvo, "codigo");
		return clienteRepository.save(clienteSalvo);
	}

	public void removerCliente(Integer codigo) {
		Cliente cliente = clienteRepository.findOne(codigo);
		clienteRepository.delete(cliente);
	}

}
