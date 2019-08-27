package com.vsm.devcase.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> verificarSeTokenEValido(){
		Map<String, Boolean> resposta = new HashMap<String, Boolean>();
		resposta.put("resposta",true);
		return resposta;
	}
}
