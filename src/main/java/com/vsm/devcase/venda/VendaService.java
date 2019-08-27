package com.vsm.devcase.venda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vsm.devcase.cliente.Cliente;
import com.vsm.devcase.cliente.ClienteRepository;
import com.vsm.devcase.exception.DevcaseException;
import com.vsm.devcase.regra.Regra;
import com.vsm.devcase.regra.RegraService;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private RegraService regraService;

	/**
	 * Método que tem como função buscar todas as vendas da aplicação!
	 * 
	 * @return List<Venda>
	 */
	public List<Venda> buscarVendas() {
		return vendaRepository.findAll();
	}

	/**
	 * Método que tem como função cadastrar a venda e bonificar o cliente caso o
	 * mesmo tenha uma venda com valor no intervalo de uma das regras cadastradas!
	 * 
	 * @param venda
	 * @return Venda
	 */
	public Venda cadastrarVenda(Venda venda) {
		Cliente cliente = clienteRepository.findOne(venda.getCliente().getCodigo());
		Regra regra = regraService.buscarRegraComValor(venda.getValor());
		if (regra != null) {
			cliente.setPontuacao(cliente.getPontuacao() + regra.getPontos());
		}
		Cliente novoCliente = clienteRepository.findOne(venda.getCliente().getCodigo());
		BeanUtils.copyProperties(cliente, novoCliente, "codigo");
		return vendaRepository.save(venda);
	}

	/**
	 * Método que tem como função buscar as vendas dentro de um período informado por dois parâmetros(de, ate)!
	 * @param de
	 * @param ate
	 * @return List<Venda>
	 */
	public List<Venda> buscarVendas(String de, String ate) {
		List<Venda> vendas = vendaRepository.findAllByDataGreaterThanEqualAndDataLessThanEqual(de, ate);
		if (vendas.size() == 0) {
			throw new DevcaseException("Não há vendas neste periodo ", HttpStatus.NOT_FOUND);
		}
		return vendas;
	}

	/**
	 * Método que tem como função buscar as vendas dentro de um período e feitas por um determinado sexo!
	 * @param de
	 * @param ate
	 * @param sexo
	 * @return List<Venda>
	 */
	public List<Venda> buscarVendasPorPeriodoESexo(String de, String ate, String sexo) {
		List<Venda> vendas = this.buscarVendas();
		List<Venda> vendaPorSexo = new ArrayList<Venda>();
		vendas.forEach(venda -> {
			if (venda.getCliente().getSexo().equals(sexo)) {
				vendaPorSexo.add(venda);
			}
		});
		return vendaPorSexo;
	}

}
