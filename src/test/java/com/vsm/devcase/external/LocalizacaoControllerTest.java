package com.vsm.devcase.external;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.external.entidades.Cidade;
import com.vsm.devcase.external.entidades.Estado;

/**
 * Classe de testes unitários para testar o consumo da API externa de
 * localização.
 * 
 * @author Gabriel Alan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class LocalizacaoControllerTest {

	RestTemplate restTemplate;

	/**
	 * Método que tem como função testar a busca de estados.
	 */
	@Test
	public void getEstadosTest() {
		restTemplate = new RestTemplate();
		Estado estadoSP = new Estado("SP", null);
		List<Estado> estados = restTemplate.exchange("http://localhost:8080/localizacao/UF", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Estado>>() {
				}).getBody();
		assertEquals(estadoSP, estados.get(estados.size() - 3));
	}

	/**
	 * Método que tem como função testar a busca de uma cidade de um estado.
	 */
	@Test
	public void getCidadeDeSPTest() {
		restTemplate = new RestTemplate();
		Cidade cidade = new Cidade(null, "Assis");
		List<Cidade> cidades = restTemplate.exchange("http://localhost:8080/localizacao/SP/cidades", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Cidade>>() {
				}).getBody();
		assertEquals(cidade, cidades.get(46));
	}

	/**
	 * Método que tem como função testar a busca por um estado inexistente e
	 * verificar se o tamanho da lista possui valor 0.
	 */
	@Test
	public void getCidadeDeEstadoInexistente() {
		restTemplate = new RestTemplate();
		List<Cidade> cidades = restTemplate.exchange("http://localhost:8080/localizacao/NY/cidades", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Cidade>>() {
				}).getBody();
		assertEquals(cidades.size(), 0);
	}

}
