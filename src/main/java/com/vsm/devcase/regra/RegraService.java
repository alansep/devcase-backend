package com.vsm.devcase.regra;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegraService {

	@Autowired
	private RegraRepository regraRepository;

	public List<Regra> buscarRegras() {
		return regraRepository.findAll();
	}

	public Regra adicionarRegra(Integer valor, Integer pontos) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra novaRegra;	
		if (regras.size() == 0) {
			 novaRegra = new Regra(null, valor, 0, pontos);
			return regraRepository.save(novaRegra);
		} else {
			Regra ultimaRegra = regras.get(0);
			if(ultimaRegra.getValorMaximo() > valor) {
				throw new IllegalArgumentException("Valor informado é menor que o último valor suportado!");
			}
			novaRegra = new Regra(null, valor, ultimaRegra.getValorMaximo(), pontos);
			return regraRepository.save(novaRegra);
		}
	}
	
	public void removerRegra(Integer codigo) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra regra = regraRepository.findOne(codigo);
		if(!regra.equals(regras.get(0))) {
			throw new IllegalArgumentException("Somente a regra com maior valor pode ser deletada!");
		} else {
			regraRepository.delete(codigo);
		}
	}
}
