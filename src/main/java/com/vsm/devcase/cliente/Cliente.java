package com.vsm.devcase.cliente;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe de modelo de Cliente
 * @author Gabriel Alan
 * 
 */
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_codigo")
	private Integer codigo;

	@NotNull
	@Column(name = "cli_pontuacao")
	private Integer pontuacao;

	@NotNull
	@Size(max = 80)
	@Column(name = "cli_nome")
	private String nome;

	@NotNull
	@Column(name = "cli_idade")
	private Integer idade;

	@NotNull
	@Size(max = 1)
	@Column(name = "cli_sexo")
	private String sexo;

	@NotNull
	@Size(max = 60)
	@Column(name = "cli_email")
	private String email;

	@NotNull
	@Size(max = 20)
	@Column(name = "cli_telefone")
	private String telefone;

	@Embedded
	private Endereco endereco;

	public Cliente(Integer codigo, Integer pontuacao, String nome, Integer idade, String sexo, String email,
			String telefone, Endereco endereco) {
		this.codigo = codigo;
		this.pontuacao = pontuacao;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Cliente() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
