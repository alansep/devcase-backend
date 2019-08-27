package com.vsm.devcase.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe Embeddable para agrupar os dados de endereço do Cliente.
 * 
 * @author Gabriel Alan
 *
 */
@Embeddable
class Endereco {

	@NotNull
	@Size(max = 100)
	@Column(name = "cli_rua")
	private String rua;

	@NotNull
	@Size(max = 80)
	@Column(name = "cli_bairro")
	private String bairro;

	@NotNull
	@Size(max = 5)
	@Column(name = "cli_numero")
	private String numero;

	@Size(max = 5)
	@Column(name = "cli_complemento")
	private String complemento;

	@NotNull
	@Size(max = 2)
	@Column(name = "cli_estado")
	private String estado;

	@NotNull
	@Size(max = 50)
	@Column(name = "cli_cidade")
	private String cidade;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
