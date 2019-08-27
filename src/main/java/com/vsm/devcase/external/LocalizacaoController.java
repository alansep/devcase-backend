package com.vsm.devcase.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService localizacaoService;
	
	@GetMapping("/UF")
	public ResponseEntity<?> getEstados(){
		return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.getEstados());
	}
		
	@GetMapping("/{estado}/cidades")
	public ResponseEntity<?> getCidades(@PathVariable String estado){
		return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.getCidades(estado));
	}
	
}
