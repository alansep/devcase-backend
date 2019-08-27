package com.vsm.devcase.regra;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe de endpoints referente as Regras da aplicação. As regras funcionam
 * como uma pilha, a primeira a entrar deverá ser a primeira a sair para que os
 * dados mantenham-se consistentes!
 * 
 * @author Gabriel Alan
 * 
 *
 */
@RestController
@RequestMapping("/regras")
public class RegraController {

	@Autowired
	private RegraService regraService;

	/**
	 * Método que tem como função buscar todas as Regras da aplicação.
	 * 
	 * @return ResponseEntity<?>
	 */
	@GetMapping
	public ResponseEntity<?> buscarRegras() {
		List<Regra> regras = regraService.buscarRegras();
		return ResponseEntity.status(HttpStatus.OK).body(regras);
	}

	/**
	 * Método que tem como função buscar o valor mínimo disponível para adicionar à
	 * uma regra.
	 * 
	 * @return ResponseEntity<Map<String,Integer>>
	 */
	@GetMapping("/valor-minimo")
	public ResponseEntity<?> buscarValorMinimo() {
		Map<String, Integer> valor = regraService.buscarValorMinimo();
		return ResponseEntity.status(HttpStatus.OK).body(valor);
	}

	/**
	 * Método que tem como função cadastrar uma regra à aplicação.
	 * 
	 * @param valor
	 * @param pontos
	 * @return ResponseEntity<?>
	 */
	@PostMapping
	public ResponseEntity<?> adicionarRegra(@RequestParam Integer valor, @RequestParam Integer pontos) {
		Regra novaRegra = regraService.adicionarRegra(valor, pontos);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaRegra);
	}

	/**
	 * Método que tem como função remover uma regra por meio de um código informado.
	 * 
	 * @param codigo
	 */
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerRegra(@PathVariable Integer codigo) {
		regraService.removerRegra(codigo);
	}
}
