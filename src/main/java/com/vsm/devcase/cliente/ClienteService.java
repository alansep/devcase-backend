package com.vsm.devcase.cliente;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vsm.devcase.exception.DevcaseException;

/**
 * Classe de Serviço com as regras de negócio dos dados de Clientes.
 * 
 * @author Gabriel
 *
 */
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Método que tem como função buscar todos os Clientes.
	 * 
	 * @param pageable
	 * @return Page<Cliente>
	 */
	public Page<Cliente> buscarTodosOsClientes(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	/**
	 * Método que tem como função cadastrar um cliente. Observação: Todos os
	 * clientes serão cadastrados com a pontuação no valor de 0!
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente cadastrarCliente(Cliente cliente) {
		cliente.setPontuacao(0);
		return clienteRepository.save(cliente);
	}

	/**
	 * Método que tem como função buscar um cliente através de um código.
	 * 
	 * @param codigo
	 * @return Cliente
	 */
	public Cliente buscarCliente(Integer codigo) {
		Cliente cliente = clienteRepository.findOne(codigo);
		if (cliente == null) {
			throw new DevcaseException("Cliente não encontrado!", HttpStatus.NOT_FOUND);
		}
		return cliente;
	}

	/**
	 * Método que tem como função atualizar um cliente!
	 * 
	 * @param codigo
	 * @param cliente
	 * @return Cliente
	 */
	public Cliente atualizarCliente(Integer codigo, Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.findOne(codigo);
		BeanUtils.copyProperties(cliente, clienteSalvo, "codigo");
		return clienteRepository.save(clienteSalvo);
	}

}
