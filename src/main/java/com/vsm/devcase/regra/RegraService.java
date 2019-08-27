package com.vsm.devcase.regra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vsm.devcase.exception.DevcaseException;

/**
 * Classe de Serviço referente as regras de negócio das Regras da aplicação.
 * @author alansep
 *
 */
@Service
public class RegraService {

	@Autowired
	private RegraRepository regraRepository;

	/**
	 * Método que tem como função retornar todas as regras de um sistema.
	 * @return
	 */
	public List<Regra> buscarRegras() {
		return regraRepository.findAll();
	}
	
	/**
	 * Método que tem como função adionar uma nova regra ao sistema.
	 * Cada nova regra adicionada terá obrigatóriamente como valor mínimo o valor máximo da ultima regra.
	 * @param valor
	 * @param pontos
	 * @return Regra
	 */
	public Regra adicionarRegra(Integer valor, Integer pontos) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra novaRegra;
		if (valor <= 0) {
			throw new DevcaseException("Novo valor não pode ser menor ou igual a zero!", HttpStatus.BAD_REQUEST);
		}
		if(pontos <= 0) {
			throw new DevcaseException("Os pontos da nova regra não podem ser menores ou iguais a zero!", HttpStatus.BAD_REQUEST);
		}
		if (regras.size() == 0) {
			novaRegra = new Regra(null, valor, 0, pontos);
			return regraRepository.save(novaRegra);
		} else {
			Regra ultimaRegra = regras.get(0);
			if (ultimaRegra.getValorMaximo() > valor) {
				throw new DevcaseException("Valor informado é menor que o último valor suportado!",HttpStatus.BAD_REQUEST);
			}
			if(ultimaRegra.getValorMaximo().equals(valor)) {
				throw new DevcaseException("Valor informado já está sendo utilizado como valor máximo por outra regra!", HttpStatus.BAD_REQUEST);
			}
			novaRegra = new Regra(null, valor, ultimaRegra.getValorMaximo(), pontos);
			return regraRepository.save(novaRegra);
		}
	}

	/**
	 * Método que tem como função remover uma regra por meio de seu código.
	 * @param codigo
	 */
	public void removerRegra(Integer codigo) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra regra = regraRepository.findOne(codigo);
		if (!regra.equals(regras.get(0))) {
			throw new DevcaseException("Somente a regra com maior valor pode ser deletada!", HttpStatus.BAD_REQUEST);
		} else {
			regraRepository.delete(codigo);
		}
	}

	/**
	 * Método que têm como função buscar o valor mínimo permitido para a criação de uma nova regra.
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> buscarValorMinimo() {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Map<String, Integer> valorMap = new HashMap<String, Integer>();
		if(regras.size() == 0) {
			valorMap.put("valorMinimo", 0);		
		} else {
			valorMap.put("valorMinimo", regras.get(0).getValorMaximo());		
		}
		return valorMap;
	}
	
	public Regra buscarRegraComValor(Double valor) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra regraEncontrada = null;
		for(Regra regra: regras ) {
			if(valor > regra.getValorMinimo() && valor < regra.getValorMaximo()) {
				regraEncontrada = regra;
			}
		}
		return regraEncontrada;
	}
}
