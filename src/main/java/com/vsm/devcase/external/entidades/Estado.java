package com.vsm.devcase.external.entidades;

/**
 * Classe de modelo de Estado, utilizada na requisição de serviços externos!
 * @author Gabriel Alan
 */
public class Estado {

	private String id;
	private String estado;

	public Estado(String id, String estado) {
		this.id = id;
		this.estado = estado;
	}

	public Estado() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
