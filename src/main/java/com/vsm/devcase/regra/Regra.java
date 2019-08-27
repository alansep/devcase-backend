package com.vsm.devcase.regra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "REGRA")
public class Regra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_codigo")
	private Integer codigo;

	@Column(name = "reg_valor_max")
	@NotNull
	private Integer valorMaximo;

	@Column(name = "reg_valor_min")
	@NotNull
	private Integer valorMinimo;

	@Column(name = "reg_pontos")
	@NotNull
	private Integer pontos;

	public Regra() {
	}

	public Regra(Integer codigo, Integer valorMaximo, Integer valorMinimo, Integer pontos) {
		this.codigo = codigo;
		this.valorMaximo = valorMaximo;
		this.valorMinimo = valorMinimo;
		this.pontos = pontos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Integer valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Integer getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Integer valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Regra other = (Regra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
