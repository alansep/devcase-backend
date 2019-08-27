package com.vsm.devcase.external;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.external.entidades.Cidade;
import com.vsm.devcase.external.entidades.Estado;

/**
 * Classe de serviço de Localização, responsável por consumir os servicos de
 * localização externos.
 * 
 * @author alansep
 *
 */
@Service
public class LocalizacaoService {

	private StringBuilder stringBuilder;
	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Método que tem como função retornar todos os estados do Brasil.
	 * 
	 * @return List<Estado>
	 */
	public List<Estado> getEstados() {
		settarNovoStringBuilder();
		stringBuilder.append("/estados");
		ResponseEntity<List<Estado>> response = restTemplate.exchange(stringBuilder.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Estado>>() {
				});
		return response.getBody();
	}

	/**
	 * Método que tem como função retornar todas as cidades de um estado brasileiro.
	 * 
	 * @param estado
	 * @return List<Cidade>
	 */
	public List<Cidade> getCidades(String estado) {
		settarNovoStringBuilder();
		stringBuilder.append("/estados/");
		stringBuilder.append(estado);
		stringBuilder.append("/cidades");
		System.out.println(stringBuilder.toString());
		ResponseEntity<List<Cidade>> response = restTemplate.exchange(stringBuilder.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cidade>>() {
				});
		return response.getBody();
	}

	/**
	 * Método que tem como função alocar uma nova instancia ao stringbuilder da
	 * classe.
	 */
	private void settarNovoStringBuilder() {
		stringBuilder = new StringBuilder("https://br-cidade-estado-nodejs.glitch.me");
	}

}
