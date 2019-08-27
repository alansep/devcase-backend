package com.vsm.devcase.external;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.external.entidades.Cidade;
import com.vsm.devcase.external.entidades.Estado;

@Service
public class LocalizacaoService {

	private StringBuilder stringBuilder;
	private RestTemplate restTemplate = new RestTemplate();

	public List<Estado> getEstados() {
		settarNovoStringBuilder();
		stringBuilder.append("/estados");
		ResponseEntity<List<Estado>> response = restTemplate.exchange(stringBuilder.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Estado>>() {
				});
		return response.getBody();
	}


	public Estado getEstado(String uf) {
		settarNovoStringBuilder();
		stringBuilder.append("/estados/");
		stringBuilder.append(uf);
		return restTemplate.getForObject(stringBuilder.toString(), Estado.class);
	}

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

	private void settarNovoStringBuilder() {
		stringBuilder = new StringBuilder("https://br-cidade-estado-nodejs.glitch.me");
	}
	
}
