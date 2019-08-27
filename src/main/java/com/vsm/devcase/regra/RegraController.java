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

@RestController
@RequestMapping("/regras")
public class RegraController {
	
	@Autowired
	private RegraService regraService;
	
	@GetMapping
	public ResponseEntity<?> buscarRegras(){
		List<Regra> regras = regraService.buscarRegras();
		return ResponseEntity.status(HttpStatus.OK).body(regras);
	}
	
	@GetMapping("/valor-minimo")
	public ResponseEntity<?> buscarValorMinimo(){
		Map<String,Integer> valor = regraService.buscarValorMinimo();
		return ResponseEntity.status(HttpStatus.OK).body(valor);
	}
	
	@PostMapping
	public ResponseEntity<?> adicionarRegra(@RequestParam Integer valor, @RequestParam Integer pontos){
		Regra novaRegra = regraService.adicionarRegra(valor, pontos);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaRegra);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerRegra(@PathVariable Integer codigo) {
		regraService.removerRegra(codigo);
	}
}
