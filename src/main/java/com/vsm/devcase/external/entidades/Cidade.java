package com.vsm.devcase.external.entidades;

/**
 * Classe de modelo de Cidade, utilizada na requisição de serviços externos!
 * @author Gabriel Alan
 */
public class Cidade {

	private String estadoId;
	private String cidade;

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cidade(String estadoId, String cidade) {
		this.estadoId = estadoId;
		this.cidade = cidade;
	}

	public Cidade() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		return true;
	}

}
