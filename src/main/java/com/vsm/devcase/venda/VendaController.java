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

/**
 * Classe de endpoints referentes a venda.
 * @author Gabriel Alan
 *
 */
@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	/**
	 * Método que tem como função retornar todas as vendas do sistema.
	 * @return List<Venda>
	 */
	@GetMapping
	public List<Venda> buscarVendas() {
		return vendaService.buscarVendas();
	}

	/**
	 * Método que tem como função retornar todas as vendas do sistemas em um período definido!
	 * Formato do período: yyyy/MM/dd
	 * @param de
	 * @param ate
	 * @return List<Venda>
	 */
	@GetMapping("/periodo")
	public List<Venda> buscarVendasPorPeriodo(@RequestParam String de, @RequestParam String ate) {
		return vendaService.buscarVendas(de, ate);
	}

	/**
	 * Método que tem como função retornar todas as vendas do sistemas em um período definido por clientes de um determinado sexo !
	 * Formato do período: yyyy/MM/dd
	 * @param de
	 * @param ate
	 * @param sexo
	 * @return List<Venda>
	 */
	@GetMapping("/periodo-sexo")
	public List<Venda> buscarVendasPorPeriodo(@RequestParam String de, @RequestParam String ate,
			@RequestParam String sexo) {
		return vendaService.buscarVendasPorPeriodoESexo(de, ate, sexo);
	}

	/**
	 * Método que tem como função cadastrar as vendas do sistema.
	 * @param venda
	 * @return ResponseEntity<?>
	 */
	@PostMapping
	public ResponseEntity<?> cadastrarVenda(@RequestBody Venda venda) {
		Venda vendaSalva = vendaService.cadastrarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}

}
