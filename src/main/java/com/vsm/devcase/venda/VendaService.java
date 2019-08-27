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

	
	public List<Venda> buscarVendas() {
		return vendaRepository.findAll();
	}

	public Venda cadastrarVenda(Venda venda) {
		Cliente cliente = clienteRepository.findOne(venda.getCliente().getCodigo());
		Regra regra = regraService.buscarRegraComValor(venda.getValor());
		cliente.setPontuacao(cliente.getPontuacao() + regra.getPontos());
		Cliente novoCliente = clienteRepository.findOne(venda.getCliente().getCodigo());
		BeanUtils.copyProperties(cliente, novoCliente, "codigo");		
		return vendaRepository.save(venda);
	}

	public List<Venda> buscarVendasPorPeriodo(String de, String ate) {
		return buscarVendas(de, ate);
	}


	public List<Venda> buscarVendasPorPeriodoESexo(String de, String ate, String sexo) {
		List<Venda> vendas = this.buscarVendas();
		List<Venda> vendaPorSexo = new ArrayList<Venda>();
		vendas.forEach(venda -> {
			if(venda.getCliente().getSexo().equals(sexo)) {
				vendaPorSexo.add(venda);
			}
		});
		return vendaPorSexo;
	}
	
	private List<Venda> buscarVendas(String de, String ate) {
		List<Venda> vendas = vendaRepository.findAllByDataGreaterThanEqualAndDataLessThanEqual(de, ate);
		if(vendas.size()==0) {
			throw new DevcaseException("Não há vendas neste periodo ", HttpStatus.NOT_FOUND);
		}
		return vendas;
	}
}
