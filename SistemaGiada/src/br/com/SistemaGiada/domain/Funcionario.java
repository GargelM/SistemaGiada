package br.com.SistemaGiada.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "fun_codigo")
	private Integer codigo;

	@Column(name = "fun_nome", length = 45, nullable = false)
	private String nome;

	@Column(name = "fun_cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "fun_senha", length = 50, nullable = false)
	private String senha;

	@Column(name = "fun_funcao", length = 50, nullable = false)
	private String funcao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
