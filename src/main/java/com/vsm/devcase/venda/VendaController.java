package com.vsm.devcase.venda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@GetMapping
	public List<Venda> buscarVendas() {
		return vendaService.buscarVendas();
	}

	@GetMapping("/periodo")
	public List<Venda> buscarVendasPorPeriodo(@RequestParam String de, @RequestParam String ate) {
		return vendaService.buscarVendasPorPeriodo(de, ate);
	}

	@GetMapping("/periodo-sexo")
	public List<Venda> buscarVendasPorPeriodo(@RequestParam String de, @RequestParam String ate,
			@RequestParam String sexo) {
		return vendaService.buscarVendasPorPeriodoESexo(de, ate, sexo);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarVenda(@RequestBody Venda venda) {
		Venda vendaSalva = vendaService.cadastrarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}

}
