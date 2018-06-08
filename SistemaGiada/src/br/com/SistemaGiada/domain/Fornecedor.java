package br.com.SistemaGiada.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedores")
public class Fornecedor {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="for_codigo")
	private int codigo;
	
	@Column(name="for_descricao" , length=50, nullable=false)
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
