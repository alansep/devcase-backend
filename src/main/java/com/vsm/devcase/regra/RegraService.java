package com.vsm.devcase.regra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vsm.devcase.exception.DevcaseException;

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

	public void removerRegra(Integer codigo) {
		List<Regra> regras = regraRepository.findAllOrderByMaximoDesc();
		Regra regra = regraRepository.findOne(codigo);
		if (!regra.equals(regras.get(0))) {
			throw new IllegalArgumentException("Somente a regra com maior valor pode ser deletada!");
		} else {
			regraRepository.delete(codigo);
		}
	}
}
