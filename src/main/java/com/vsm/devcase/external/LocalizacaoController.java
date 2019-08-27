package com.vsm.devcase.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe de endpoints onde estão os dois métodos para busca de Estados e
 * Cidades BRASILEIRAS através de um serviço externo! OBS: É necessário possuir
 * conexão à Internet para consumir os serviços!
 * 
 * @author Gabriel
 */
@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService localizacaoService;

	/**
	 * Método que tem como função buscar todas as siglas de estados.
	 * 
	 * @return ResponseEntity<List<Estado>>
	 */
	@GetMapping("/UF")
	public ResponseEntity<?> getEstados() {
		return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.getEstados());
	}

	/**
	 * Método que tem como função buscar todas as cidades de um estado.
	 * 
	 * @return ResponseEntity<List<Estado>>
	 */
	@GetMapping("/{estado}/cidades")
	public ResponseEntity<?> getCidades(@PathVariable String estado) {
		return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.getCidades(estado));
	}

}
